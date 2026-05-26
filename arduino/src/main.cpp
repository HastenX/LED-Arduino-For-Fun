#include <Arduino.h>

// put function declarations here:
void setRGB(int, int, int, int);

void initLEDS(int,int,int);
void selectProfile();

void customProfile();
void singleProfile();
void alternateProfile();

void stageOneUni();
void stageTwoUni();
void stageThreeUni();
void stageFourUni();
void stageFiveUni();
void stageSixUni();

void stageOneAlt();
void stageTwoAlt();
void stageThreeAlt();
void stageFourAlt();
void stageFiveAlt();
void stageSixAlt();


int redPins[2]={3,9};
int greenPins[2]={5,10};
int bluePins[2]={6,11};

void setup() {
  Serial.begin(57600);
  for(int i=0; i<2; i++) {
    pinMode(redPins[i],OUTPUT);
    pinMode(greenPins[i],OUTPUT);
    pinMode(bluePins[i],OUTPUT);
  }
  initLEDS(255,81,0);
}

int signals[4]={0,0,0,0};
// Values are passed in following order: 
// index, red, green and blue
// therefore:
// [0] index, [1] red, [2] green, [3] blue
// The first itteration is skipped to avoid
// overloading.

int signalNum=0;
// int skip=2;
void loop() {
  if(signalNum==0) {
    Serial.println(1);
    Serial.flush();
  }
  if(Serial.available()>0 && signalNum<4) {
    signals[signalNum]=Serial.read();
  
    signalNum++;
  }

  if(signalNum>=4) {
    signalNum=0;
    selectProfile();
    delay(25);
  }
}

void setRGB(int index, int red, int green, int blue) {
  analogWrite(redPins[index],red/128);
  analogWrite(greenPins[index],green/128);
  analogWrite(bluePins[index],blue/128);
}

void setAllRGB(int red,int green, int blue) {
  for(int i=0; i<2; i++) {
    setRGB(i, red, green, blue);
  }
}

void initLEDS(int red, int green, int blue) {
  for(int i=0; i<3; i++) {
    for(int j=0; j<2; j++) {
      setRGB(j,red,green,blue);
    }
    delay(500);
    for(int j=0; j<2; j++) {
      setRGB(j,0,0,0);
    }
    delay(500);
  }
}

int currentProfile=0;
int currentStageOfProfile=1;

void selectProfile() {
  switch (signals[0]) {
    case 0:
      customProfile();
      currentStageOfProfile=1;
      break;
    case 1:
      singleProfile();
      break;
    case 2:
      alternateProfile();
      break;
    default:
      initLEDS(255,0,0);
      break;
  }
  currentProfile=signals[0];
}

void customProfile() {
  for(int i=0; i<2; i++) {
    setRGB(i, signals[1], signals[2], signals[3]);
  }
}

int r=255;
int g=0;
int b=0;

void singleProfile() {
  switch (currentStageOfProfile) {
    case 1:
      stageOneUni();
      currentStageOfProfile++;
      break;
    case 2:
      stageTwoUni();
      currentStageOfProfile++;
      break;
    case 3:
      stageThreeUni();
      currentStageOfProfile++;
      break;
    case 4:
      stageFourUni();
      currentStageOfProfile++;
      break;
    case 5:
      stageFiveUni();
      currentStageOfProfile++;
      break;
    case 6:
      stageSixUni();
      currentStageOfProfile=1;
      break;
  }
}

void alternateProfile() {
  switch (currentStageOfProfile) {
    case 1:
      stageOneAlt();
      currentStageOfProfile++;
      break;
    case 2:
      stageTwoAlt();
      currentStageOfProfile++;
      break;
    case 3:
      stageThreeAlt();
      currentStageOfProfile++;
      break;
    case 4:
      stageFourAlt();
      currentStageOfProfile++;
      break;
    case 5:
      stageFiveAlt();
      currentStageOfProfile++;
      break;
    case 6:
      stageSixAlt();
      currentStageOfProfile=1;
      break;
  }
}

int delayVal=15;
int incrimentVal=1;
void stageOneUni() {
  r=255;
  g=0;
  b=0;
  while(g<255) {
    g+=incrimentVal;
    setAllRGB(r,g,b);
    delay(delayVal);
  }
}

void stageTwoUni() {
  r=255;
  g=255;
  b=0;
  while(r>0) {
    r-=incrimentVal;
    setAllRGB(r,g,b);
    delay(delayVal);
  }
}

void stageThreeUni() {
  r=0;
  g=255;
  b=0;
  while(b<255) {
    b+=incrimentVal;
    setAllRGB(r,g,b);
    delay(delayVal);
  }
}

void stageFourUni() {
  r=0;
  g=255;
  b=255;
  while(g>0) {
    g-=incrimentVal;
    setAllRGB(r,g,b);
    delay(delayVal);
  }
}

void stageFiveUni() {
  r=0;
  g=0;
  b=255;
  while(r<255) {
    r+=incrimentVal;
    setAllRGB(r,g,b);
    delay(delayVal);
  }
}

void stageSixUni() {
  r=255;
  g=0;
  b=255;
  while(b>0) {
    b-=incrimentVal;
    setAllRGB(r,g,b);
    delay(delayVal);
  }
}

int r0=255;
int g0=0;
int b0=0;

int r1=0;
int g1=255;
int b1=255;

void stageOneAlt() {
  r0=255;
  g0=0;
  b0=0; 
  r1=0;
  g1=255;
  b1=255;
  while(g0<252 || g1>3) {
    if(g0<252) {
      g0+=incrimentVal;
    }
    if(g1>3) {
      g1-=incrimentVal;
    }
    setRGB(0,r0,g0,b0);
    setRGB(1,r1,g1,b1);
    delay(delayVal);
  }
}

void stageTwoAlt() {
  r0=255;
  g0=255;
  b0=0; 
  r1=0;
  g1=0;
  b1=255;
  while(r1<252 || r0>3) {
    if(r1<252) {
      r1+=incrimentVal;
    }
    if(r0>3) {
      r0-=incrimentVal;
    }
    setRGB(0,r0,g0,b0);
    setRGB(1,r1,g1,b1);
    delay(delayVal);
  }
}

void stageThreeAlt() {
  r0=0;
  g0=255;
  b0=0; 
  r1=255;
  g1=0;
  b1=255;
  while(b0<252 || b1>3) {
    if(b0<252) {
      b0+=incrimentVal;
    }
    if(b1>3) {
      b1-=incrimentVal;
    }
    setRGB(0,r0,g0,b0);
    setRGB(1,r1,g1,b1);
    delay(delayVal);
  }
}

void stageFourAlt() {
  r0=0;
  g0=255;
  b0=255; 
  r1=255;
  g1=0;
  b1=0;
  while(g1<252 || g0>3) {
    if(g1<252) {
      g1+=incrimentVal;
    }
    if(g0>3) {
      g0-=incrimentVal;
    }
    setRGB(0,r0,g0,b0);
    setRGB(1,r1,g1,b1);
    delay(delayVal);
  }
}

void stageFiveAlt() {
  r0=0;
  g0=0;
  b0=255; 
  r1=255;
  g1=255;
  b1=0;
  while(r0<252 || r1>3) {
    if(r0<252) {
      r0+=incrimentVal;
    }
    if(r1>3) {
      r1-=incrimentVal;
    }
    setRGB(0,r0,g0,b0);
    setRGB(1,r1,g1,b1);
    delay(delayVal);
  }
}

void stageSixAlt() {
  r0=255;
  g0=0;
  b0=255; 
  r1=0;
  g1=255;
  b1=0;
  while(b1<252 || b0>3) {
    if(b1<252) {
      b1+=3;
    }
    if(b0>3) {
      b0-=3;
    }
    setRGB(0,r0,g0,b0);
    setRGB(1,r1,g1,b1);
    delay(delayVal);
  }
}
