import argparse
import os
import sys
import stat
import locale
import time

# parse args
parser = argparse.ArgumentParser(description='List information about the FILEs (the current directory by default).')
parser.add_argument('-l', '--list', action='store_true',
                    help='use a long listing format')
parser.add_argument('-a', '--all', action='store_true',
                    help='do not ignore entries starting with .')
parser.add_argument('-i', '--inode', action='store_true',
                    help='print the index number of each file')
parser.add_argument('FILE', nargs='*',
                    help='FILEs to be listed (the current directory by default)')
args = parser.parse_args()

# get files
if len(args.FILE) == 0:
    files = os.listdir('.')
    if not args.all:
        # ignore files starting with '.'
        files = [filename for filename in files if filename[0] != '.']
else:
    files = args.FILE

# do locale sensitive sort of files to list
locale.setlocale(locale.LC_ALL, '')
files.sort(key=locale.strxfrm)

# setup global variables (dictionary)
now = int(time.time())
recent = now - (6*30*24*60*60) #6 months ago

# function to get info from mode
def get_mode_info(mode):
    perms = '-'
    link = ''
    if stat.S_ISDIR(mode):
        perms = 'd'
    elif stat.S_ISLNK(mode):
        perms = 'l'
        link = os.readlink(filename)
    mode = stat.S_IMODE(mode)
    for who in 'USR', 'GRP', 'OTH':
        for what in 'R', 'W', 'X':
            #lookup attribute at runtime using getattr
            if mode & getattr(stat,'S_I' + what + who):
                perms = perms + what.lower()
            else:
                perms = perms + '-'
    # return multiple bits of info in a tuple
    return (perms, link)

# process each file in list using a for loop
for filename in files:
    try: #exceptions
        # get all the file info
        stat_info = os.lstat(filename)
    except:
        sys.stderr.write('%s: No such file or directory\n' % filename)
        continue

    if args.list:
        # show detail file info by list
        perms, link = get_mode_info(stat_info.st_mode)
        nlink = '%4d' % stat_info.st_nlink
        name = '%-8s' % stat_info.st_uid
        group = '%-8s' % stat_info.st_gid
        size = '%8d' % stat_info.st_size
        ts = stat_info.st_mtime
        if (ts < recent) or (ts > now):
            time_fmt = '%b %e  %Y'
        else:
            time_fmt = '%b %e %R'
        time_str = time.strftime(time_fmt, time.gmtime(ts))
        if args.inode:
            inode = '%-32s' % stat_info.st_ino
            sys.stdout.write('%s %s %s %s %s %s %s ' % (inode, perms, nlink, name, group, size, time_str))
        else:
            sys.stdout.write('%s %s %s %s %s %s ' % (perms, nlink, name, group, size, time_str))
        sys.stdout.write(filename)
        if link:
            sys.stdout.write(' -> ')
        print(link)
    else:
        # show simple file info
        if args.inode:
            sys.stdout.write('%s %s ' % (stat_info.st_ino, filename))
        else:
            sys.stdout.write('%s ' % filename)
