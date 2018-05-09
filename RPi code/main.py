import RPi.GPIO as GPIO

GPIO.setmode(GPIO.BCM)
GPIO.setwarnings(False)

p=11

GPIO.setup(p,GPIO.IN)

while True:
    x=GPIO.input(p)
    print (x)
