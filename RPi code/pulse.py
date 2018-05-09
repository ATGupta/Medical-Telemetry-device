import time
def pulse(v,s):
    i=0
    """while True:
        st = "PL"+str(i)+"\n"
        s.send(st.encode())
        i+=1
        time.sleep(1)
    pass"""
    st = "PL"+str(v)+"\n"
    s.send(st.encode())
