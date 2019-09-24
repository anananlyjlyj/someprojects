import time
import serial
import numpy as np
import matplotlib.pyplot as plt
import imageio


def getsig():
    x=ser.readline(1)
    xx = np.uint8(x[0])
    return xx

ser = serial.Serial(
    port='/dev/serial0',
    baudrate = 115200,
    parity=serial.PARITY_NONE,
    stopbits=serial.STOPBITS_ONE,
    bytesize=serial.EIGHTBITS,
    timeout=1
)
counter=0
low = False

im = imageio.imread('bicycle.png')

fig = plt.figure()
fig.patch.set_facecolor('k')
plt.imshow(np.zeros((2,2)), cmap = 'gray')
plt.axis('off')

mng = plt.get_current_fig_manager()
mng.full_screen_toggle()
plt.clim(199,1000)

plt.draw()
plt.pause(1e-10)

while 1:
    ser.flush()
    c = getsig()
    
    while c!=89:
        c = getsig()
        #print(c)
    c = getsig()
    if c == 89:
        a = getsig()
        b = getsig()
        val = b*256+a
        #print(val)
        if val < 180:
            if not low:
                print('low')
            low = True
            plt.imshow(im[:-100,:])
            plt.axis('off')

            plt.draw()
            plt.pause(1e-10)
        else:
            if low:
                print('high')
            low = False
    #binascii.hexlify(x.encode('utf8'))