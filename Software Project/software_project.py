from grovepi import *
from firebase import firebase
import time
import json
import time

firebase_url = 'https://software-project-4ae0c.firebaseio.com/'

ultrasonic_ranger = 4
Relay_pin = 2

pinMode(Relay_pin, "OUTPUT")

fixed_interval = 10
while 1:
    try:


        distant = ultrasonicRead(ultrasonic_ranger)
        print distant, 'cm'

        if distant <= 10:
            digitalWrite(Relay_pin,1)
        else:
            digitalWrite(Relay_pin,0)

        print distant + 'cm,'

        data = {'value':distant}
        result = requests.post(firebase_url + '/distant.json', data=json(data))

        print 'Record inserted. Result Code = '+ str(result.status_code) + ',' + result.text
        time.sleep(fixed_interval)

        except IOError:
            print "Error! Something went wrong"
        time.sleep(fixed_interval)
