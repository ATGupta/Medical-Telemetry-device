import time
def temperature(v
                ,s):
    i=0
    """while True:
        st = "TM"+str(i)+"\n"
        s.send(st.encode())
        i+=1
        time.sleep(1)
    pass"""
    st = "TM"+str(v)+"\n"
    s.send(st.encode())
