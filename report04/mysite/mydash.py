import urllib.request as request
import json
import datetime
import platform
from django.http import HttpResponse

API_KEY = 'AIzaSyAd1WmhQs7jNW__qAszJSsKJVaayQv_Tsc'


# get iss position
def iss_position():
    iss_api_url = 'http://api.open-notify.org/iss-now.json'
    try:
        with request.urlopen(iss_api_url) as url:
            response = url.read()
        obj = json.loads(response.decode('utf-8'))
        return obj['iss_position']['latitude'], obj['iss_position']['longitude']
    except:
        return '40.714224', '-73.961452'  # for test


# get geo location
def geo_location(lat, lng):
    (lat, lng) = '40.714224', '-73.961452'  # for test
    geo_api_url = 'https://maps.googleapis.com/maps/api/geocode/json?latlng=%s,%s&key=%s' % (lat, lng, API_KEY)
    try:
        with request.urlopen(geo_api_url) as url:
            response = url.read()
        obj = json.loads(response.decode('utf-8'))
        return obj['results'][0]['formatted_address']
    except:
        return 'NO_RESULTS'


# get weather
def weather_forecast():
    #yql_query = 'select * from weather.forecast where woeid in (select woeid from geo.places(1) where text="Tokyo, jp")'.encode()
    yql_query = 'select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22Tokyo%2C%20jp%22)'
    weather_api_url = 'https://query.yahooapis.com/v1/public/yql?q=%s&format=json' % yql_query
    try:
        with request.urlopen(weather_api_url) as url:
            response = url.read()
        obj = json.loads(response.decode('utf-8'))
        return obj['query']['results']['channel']['item']['forecast']
    except:
        return 'NO_RESULTS'


# show my dashboard
def my_dashboard(request):
    html = '<html><body><h1>My Dashboard</h1><hr>'

    html += '<h2>Dashboard: System Information</h2>'
    html += 'Now: %s<br>' % datetime.datetime.now()
    html += 'Platform: %s<br>' % platform.platform()
    html += 'Version: %s<br>' % platform.version()
    html += 'Processor: %s<br>' % platform.processor()

    weathers = weather_forecast()
    html += '<h2>Dashboard: Weather Forecast (Tokyo, JP)</h2>'
    for weather in weathers:
        html += '[%s]: %s<br>' % (weather['date'], weather['text'])

    (latitude, longitude) = iss_position()
    location = geo_location(latitude, longitude)
    html += '<h2>Dashboard: ISS Location</h2>'
    html += 'The International Space Station is currently over <br>'
    html += '| Address: %s <br>| Geocode: %s, %s' % (location, latitude, longitude)

    html += '</body></html>'

    return HttpResponse(html)
