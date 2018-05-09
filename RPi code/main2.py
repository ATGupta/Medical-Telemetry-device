import socket
from threading import Thread
from pulse import pulse
from temperature import temperature
import time
import RPi.GPIO as GPIO
from array import *

GPIO.setmode(GPIO.BCM)
GPIO.setwarnings(False)

GPIO.setup(2,GPIO.IN)
GPIO.setup(3,GPIO.IN)
GPIO.setup(4,GPIO.IN)
GPIO.setup(5,GPIO.IN)
GPIO.setup(6,GPIO.IN)
GPIO.setup(7,GPIO.IN)
GPIO.setup(8,GPIO.IN)
GPIO.setup(9,GPIO.IN)
GPIO.setup(10,GPIO.IN)
GPIO.setup(11,GPIO.IN)

s = socket.socket()
print("atg 1")
host = "192.168.43.78"
print("atg 2")
port = 2017
print("atg 3")
s.connect((host,port))
print("atg 4")

#t1 = Thread(target=pulse,args=("",s))
#t2 = Thread(target=temperature,args=("",s))
#t1.start()
#t2.start()

while True:
    a=array('i',[0,0,0,0,0,0,0,0])
    v=0
    for i in range(2,10): #runs from 2 to 9
        inp=GPIO.input(i)
        v=v*2+inp
        a[i-2]=inp
    flag = 0
    for i in range(10,12): #runs from 10 to 11
       flag=flag*2+GPIO.input(i)

    print(str(v)+"#t"+str(flag))
    print(a)
    
    if flag is 0:
        temperature(v,s)
    else:
        if flag is 1:
            pulse(v,s)
    
    
    time.sleep(1)


s.close
