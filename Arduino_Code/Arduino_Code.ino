int arr[]={0,0,0,0,0,0,0,0};
int v;
void setup() {
 Serial.begin(9600);

 pinMode(A0,INPUT);//temperature
 pinMode(A1,INPUT);//pulse
 pinMode(2,OUTPUT);
 pinMode(3,OUTPUT);
 pinMode(4,OUTPUT);
 pinMode(5,OUTPUT);
 pinMode(6,OUTPUT);
 pinMode(7,OUTPUT);
 pinMode(8,OUTPUT);
 pinMode(9,OUTPUT);

 pinMode(10,OUTPUT);
 pinMode(11,OUTPUT);

 //v=analogRead(A0);
}
void loop() {
 //settemperature(v);
 v=analogRead(A0);
 settemperature(v);

 Serial.print(v);

 Serial.println("\tzero");

 delay(1000);

 v=analogRead(A1);
 setPulse(v);

 Serial.print(v);
 Serial.println("\tone");

 delay(1000);
}
void settemperature(int v){
 digitalWrite(9,v%2);arr[7]=v%2;v=v/2;
 digitalWrite(8,v%2);arr[6]=v%2;v=v/2;
 digitalWrite(7,v%2);arr[5]=v%2;v=v/2;
 digitalWrite(6,v%2);arr[4]=v%2;v=v/2;
 digitalWrite(5,v%2);arr[3]=v%2;v=v/2;
 digitalWrite(4,v%2);arr[2]=v%2;v=v/2;
 digitalWrite(3,v%2);arr[1]=v%2;v=v/2;
 digitalWrite(2,v%2);arr[0]=v%2;v=v/2;

 digitalWrite(11,0);
 digitalWrite(10,0);
 for(int i=0;i<8;i++){
 Serial.print(arr[i]);
 }
 Serial.println();
}
void setPulse(int v){
 digitalWrite(9,v%2);arr[7]=v%2;v=v/2;
 digitalWrite(8,v%2);arr[6]=v%2;v=v/2;

 digitalWrite(7,v%2);arr[5]=v%2;v=v/2;
 digitalWrite(6,v%2);arr[4]=v%2;v=v/2;
 digitalWrite(5,v%2);arr[3]=v%2;v=v/2;
 digitalWrite(4,v%2);arr[2]=v%2;v=v/2;
 digitalWrite(3,v%2);arr[1]=v%2;v=v/2;
 digitalWrite(2,v%2);arr[0]=v%2;v=v/2;

 digitalWrite(11,1);
 digitalWrite(10,0);
 for(int i=0;i<8;i++){
 Serial.print(arr[i]);
 }
 Serial.println();
}
