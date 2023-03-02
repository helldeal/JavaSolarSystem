import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.List; 
import java.util.List; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Universe extends PApplet {


soleil soleil = new soleil("soleil",40,"soleil.jpg");
terre terre = new terre("terre",500,11,"terre.jpg",0.2f/100,random(0,360));
mercure mercure = new mercure("mercure",100,4,"mercure.jpg",0.5f/100,random(0,360));
venus venus = new venus("venus",200,9,"venus.jpg",0.3f/100,random(0,360));
mars mars = new mars("mars",700,8,"mars.jpg",0.1f/100,random(0,360));
jupiter jupiter = new jupiter("jupiter",3000,100,"jupiter.jpg",0.05f/100,random(0,360));
saturne saturne = new saturne("saturne",3500,80,"saturne.jpg",0.01f/100,random(0,360));
uranus uranus = new uranus("uranus",4000,40,"uranus.jpg",0.005f/100,random(0,360));
neptune neptune = new neptune("neptune",4500,40,"neptune.jpg",0.001f/100,random(0,360));
sattelite lune = new sattelite(25,3,"lune.jpg",0.1f,random(0,360),1);
sattelite luneJ1 = new sattelite(125,3,"lune.jpg",0.1f,random(0,360),1);
sattelite luneJ2 = new sattelite(150,3,"lune.jpg",0.1f,random(0,360),2);
sattelite luneJ3 = new sattelite(200,3,"lune.jpg",0.1f,random(0,360),1);
sattelite luneJ4 = new sattelite(175,3,"lune.jpg",0.1f,random(0,360),2);
List<HyperSpaceVisual> HSV = new ArrayList<HyperSpaceVisual>();

int stars= 200;

PImage cockpit;

public void setup() {
  
  mainCamera = new FPCamera();
  cameraEnabled = true; 
  cockpit = loadImage("cockpit.png");
  souris = loadImage("souris.png");
  LMB = loadImage("LMB.png");
  RMB = loadImage("RMB.png");
  LMB_RMB = loadImage("LMB+RMB.png");
  fondtex = loadImage("fond.png");
  fond = createShape(SPHERE, 5000);   
  fond.setStroke(false);
  fond.setTexture(fondtex);
  for(int i=0; i<=aste; i++){
     asteroide.add(new asteroide (random(100,135),1,"aste.jpg",0.01f,random(0,360),2));}
  for(int i=0; i<=stars; i++){
  HSV.add(new HyperSpaceVisual (random(-width*1,width*2),random(-height*1,height*2),random(500,-5000),random(50,100)));}
  
}

public void draw() {
  textAlign(LEFT);
   background(0); 
   soleil.display();
   shape(fond);
  terre.display();
  mercure.display();
  venus.display();
  mars.display();
  jupiter.display();
  saturne.display();
  uranus.display();
  neptune.display();
   if(switchplanet == 1&&noclip==false)HUD();
  translate(-(width/2), -(height/2), -0);
  
  vaisseau();
}
 
      
public void drawAxis(){
  translate(width/2, height/2, 0);
  stroke(0,255,0);
  line(0,0,0,100,0,0);
  stroke(0,0,255);
  line(0,0,0,0,100,0);
  stroke(255,0,0);
  line(0,0,0,0,0,-100);
  noStroke();
  translate(-(width/2), -(height/2), -0);
}
PImage souris;
PImage LMB;
PImage RMB;
PImage LMB_RMB;

public void HUD(){
 hint(DISABLE_DEPTH_TEST); 
  
  textSize(15);
  camera();
  noStroke();
  rectMode(CENTER);
  fill(255);
  textAlign(CENTER);
  text ("Press 'Tab' to set info ",width/2,30);
  textAlign(RIGHT);
  text ("Press 'V' to switch view",width-30,30);
  textAlign(LEFT);
  text ("'Esc' to EXIT",30,30);
  
  fill(255);
  image(souris,width-50,height-50,40,40);
  text("'LMB' to rotate",width-160,height-35);
  text("'RMB' to zoom",width-160,height-15);
   if (mouseButton == LEFT){image(LMB,width-50,height-50,40,40);fill(255,0,0);text("'LMB' to rotate",width-160,height-35);}
   if (mouseButton == RIGHT){image(RMB,width-50,height-50,40,40);fill(255,0,0);text("'RMB' to zoom",width-160,height-15);}
   
  fill(255);
  if(!Stat)text ("'F3'",30,60);
  noFill();
  noStroke();
    if(Stat){   
  fill(255);
  textAlign(LEFT);
  text ("fps "+round(frameRate), 30, 60);
  noFill();
  noStroke();
    }

  hint(ENABLE_DEPTH_TEST); 
  }
class HyperSpaceVisual{
float x;
float y;
float z;
float vit;
HyperSpaceVisual (float x, float y, float z, float vit){
  this.x =x;
  this.y = y;
  this.z = z;
  this.vit = vit;
}
public void display(){
  z = z+=vit;
  fill(255,200);
  stroke(255,200);
  line(x,y,z-1000,x,y,z);
  noStroke();
  lights();
  translate(x, y, z);
  translate(-x, -y, -z);
  if (z > 500){
    z = -5000;
  }
}
}
PImage soleiltex;
PShape soleilS;
PImage lunetex;
PShape luneS;
PShape neptuneS;
PImage neptunetex;
PImage mercuretex;
PShape mercureS;
PImage venustex;
PShape venusS;
PImage terretex;
PShape terreS;
PImage marstex;
PShape marsS;
PImage jupitertex;
PShape jupiterS;
PImage saturnetex;
PShape saturneS;
PImage uranustex;
PShape uranusS;

PImage fondtex;
PShape fond;
PShape asteS;
PImage astetex;

    int LoadHS=0;
    
      int Timer;

public void vaisseau(){

if (noclip==true){ 
    if (cameraEnabled == true) {
      
  
  hint(DISABLE_DEPTH_TEST); 
  
  textSize(15);
  camera();
  noStroke();
  fill(255); 
  rectMode(CENTER);
  textAlign(CENTER);
  rect(30,height-30,40,40);
  if(!isBoost){
    LoadHS = 0;
    fill(255);
    text("Press 'Shift' to activate the space navigation",width/2,height/3+5);}
  if(isBoost&&isForward){
    if(LoadHS<300){
      LoadHS = LoadHS + 2;
      float TimerHS = map(LoadHS,0,300,3,0);
      fill(255,120);
      rect(width/2,height/3,150,20);
      rectMode(LEFT);
      float lgrect = map(LoadHS,0,300,0,150);
      fill(255);
      rect((width/2)-75,height/3-10,(width/2)-75+lgrect,height/3-10+20);
      fill(255,0,0);
      text(TimerHS,width/2,height/3+5);
}
    if (LoadHS>=300){
      for(int i=0; i<=stars; i++){  
      HSV.get(i).display();}
      Timer = Timer + 12;
      if(Timer>200)Timer=0;
      if (Timer<100){
      fill(255,0,0);}
      if (Timer>100){
      fill(255);}
      text("HYPERSPACE ACTIVATED",width/2,height/3+5);
    }
  }
  image(cockpit,0,0,width,height);
  fill(255); 
  rectMode(CENTER);
  textAlign(CENTER);
  text ("Press 'Tab' to set info ",width/2,30);
  textAlign(RIGHT);
  text ("Press 'V' to switch view",width-30,30);
  textAlign(LEFT);
  text ("'Esc' to EXIT",30,30);
  if(!Stat)text ("'F3'",30,60);
  textAlign(CENTER);
  fill(255,100);
  if(isLeft)fill(255,0,0,200);
  rect(50,height-50,40,40);
  fill(255);
  text("Q",50,height-45);
  fill(255,100);
  if(isBack)fill(255,0,0,200);
  rect(100,height-50,40,40);
  fill(255);
  text("S",100,height-45);
  fill(255,100);
  if(isRight)fill(255,0,0,200);
  rect(150,height-50,40,40);
  fill(255);
  text("D",150,height-45);
  fill(255,100);
  if(isForward)fill(255,0,0,200);
  rect(100,height-100,40,40);
  fill(255);
  text("Z",100,height-95);
   fill(255,100);
  if(isUp)fill(255,0,0,200);
  rect(250,height-100,60,40);
  fill(255);
  text("SPACE",250,height-95);
  fill(255,100);
  if(isDown)fill(255,0,0,200);
  rect(250,height-50,40,40);
  fill(255);
  text("CTRL",250,height-45);
  
  noFill();
  noStroke();

  hint(ENABLE_DEPTH_TEST); }
  

  mainCamera.camTransformations();
}
}

List<asteroide> asteroide = new ArrayList<asteroide>();
int aste = 2000;
class asteroide{
float distance;
float taille;
String texture;
float vitesse;
float yy;
float pos;
asteroide( float distance, float taille, String texture, float vitesse, float yy,float pos){
  this.distance = distance;
  this.taille = taille;
  this.texture = texture;
  this.vitesse = vitesse;
  this.yy = yy;
  this.pos = pos;
}
  
public void ldisplay(){
  setuptex();
  yy = yy+vitesse;
  if (pos == 2){
  rotateZ(radians(-5));
  rotateX(radians(-10));
  rotateY(radians(yy));
  translate(distance+40,0,0);
  shape(asteS);
  translate(-distance-40,0,0);
  translate(distance,0,0);
  shape(asteS);
  translate(-distance,0,0);
  rotateY(radians(-yy));
  rotateX(radians(10));
  rotateZ(radians(5));
}
}
}
float refresh=0;
public void setuptex(){ 
  if (refresh<1){
  refresh=refresh+1;
  astetex = loadImage("aste.jpg");
  asteS = createShape(SPHERE, 1);   
  asteS.setTexture(astetex);
  asteS.setStroke(false);
  }}
int winSizeX =  1280;
int winSizeY = 720;

//center
int cx = winSizeX/2;
int cy = winSizeY/2;
int cz = 0;

//camera positions
float camEyeX = 0;
float camEyeY = 0;
float camEyeZ = 0;
float viewX = cx;
float viewY = cy;
float viewZ = cz;
float camUpX = 0;
float camUpY = 1;
float camUpZ = 0;

//Polar coordinates
float theta = 0;      
float phi = 0;       
float rho = 350;   //distance from cam to point of view

float moveZ=0;
public void updateCamPosition() {
    
    
  if(noclip==false){
  camEyeX = rho * cos(radians(theta)) * cos(radians(phi)) + cx;
  camEyeY = rho * sin(radians(theta)) + cy;
  camEyeZ = rho * cos(radians(theta)) * sin(radians(phi));
}
}

public void mouseDragged() {
  if(noclip==false){
  if (mouseButton == LEFT && theta<=80 && theta >=-80){
    theta = theta + (pmouseY - mouseY);
    phi = phi - (pmouseX - mouseX);
  }

  if (mouseButton == RIGHT) {
    rho = rho - (pmouseY - mouseY);
  }
  if (theta>80)theta=80;
  if (theta<-80)theta=-80;
}
} 
boolean cameraEnabled = false;
FPCamera mainCamera;
class FPCamera {



  // The Main camera's position.

  PVector cameraPosition;



  // Movement velocity and acceleration.

  PVector velocity;

  PVector acceleration;

  // The camera's maximum speed.

  float topspeed;



  boolean enableFly = false;


    float slidecam=width/2;

  FPCamera() {

    cameraPosition = new PVector( width/2, height/2+50, (  height/2) / tan(PI*30 / 180));
    velocity = new PVector(0, 0);

    topspeed = 0.2f;
  }







  // All transformations applyed to the camera are here.

  public void camTransformations() {

     if(Stat){   
  hint(DISABLE_DEPTH_TEST); 
  
  textSize(15);
  camera();
  fill(255);
  textAlign(LEFT);
  text ("fps "+round(frameRate), 30, 60);
  fill(255,0,0);text ("x = "+cameraPosition.x, 30, 80);
  fill(0,255,0);text ("y = "+cameraPosition.y, 30, 100);
  fill(0,0,255);text ("z = "+cameraPosition.z, 30, 120);
  noFill();
  noStroke();

  hint(ENABLE_DEPTH_TEST); 
  

}

    // Camera rotation


    pushMatrix();

    translate(cameraPosition.x, cameraPosition.y, cameraPosition.z);



    // Side to side movment
    slidecam =slidecam+(pmouseX-mouseX);
    rotateY(slidecam*0.01f);



    translate(0, 0, -200);

    //ball(0, 0, 0, 20);



    float x = modelX(0, 0, 0);

    float y = modelY(0, 0, 0);

    float z = modelZ(0, 0, 0);

    popMatrix();





    // Up and down movment.

    y = map(mouseY, 0, height, -1200, 1200);



    camera(cameraPosition.x, cameraPosition.y, cameraPosition.z, x, cameraPosition.y+y, z, 0, 1, 0);
    println(x,y,z);



    // Camera positional movment.



    // Move Forward when pressing W.

    if (isForward) {

        // Compute a vector that points from location to mouse.

        //PVector targetPosition = new PVector(x, y, z);

        PVector targetPosition = new PVector(x, cameraPosition.y, z);

        PVector acceleration = PVector.sub(targetPosition, cameraPosition);

        // Set magnitude of acceleration

        acceleration.setMag(0.05f);



        // Velocity changes according to acceleration

        velocity.add(acceleration);

        // Limit the velocity by topspeed

        velocity.limit(topspeed);

        // Location changes by velocity

        cameraPosition.add(velocity);
        if (isBoost&&LoadHS>=300){acceleration.setMag(1);velocity.add(acceleration);velocity.limit(1);cameraPosition.add(velocity);cameraPosition.add(velocity);cameraPosition.add(velocity);}
      }
    
    if (isLeft) {

        // Compute a vector that points from location to mouse.

        //PVector targetPosition = new PVector(x, y, z);
        
        PVector targetPosition = new PVector(x, cameraPosition.y, z);
       

        PVector acceleration = PVector.sub(targetPosition, cameraPosition);
         
        // Set magnitude of acceleration

        acceleration.setMag(0.05f);
        

        // Velocity changes according to acceleration

        velocity.add(acceleration);

        // Limit the velocity by topspeed

        velocity.limit(topspeed);

        // Location changes by velocity

        cameraPosition.add(velocity);
      }
    
    if (isRight) {

        // Compute a vector that points from location to mouse.

        //PVector targetPosition = new PVector(x, y, z);

        PVector targetPosition = new PVector(x, cameraPosition.y, z);

        PVector acceleration = PVector.sub(targetPosition, cameraPosition);

        // Set magnitude of acceleration

        acceleration.setMag(-0.05f);



        // Velocity changes according to acceleration

        velocity.add(acceleration);

        // Limit the velocity by topspeed

        velocity.limit(topspeed);

        // Location changes by velocity

        cameraPosition.add(velocity);
      }
    



    // Move backwards when pressing S.

    if (isBack) {

        // Compute a vector that points from location to mouse.

        //PVector targetPosition = new PVector(x, y, z);

        PVector targetPosition = new PVector(x, cameraPosition.y, z);

        PVector acceleration = PVector.sub(targetPosition, cameraPosition);

        // Set magnitude of acceleration

        acceleration.setMag(-0.05f);



        // Velocity changes according to acceleration

        velocity.add(acceleration);

        // Limit the velocity by topspeed

        velocity.limit(topspeed);

        // Location changes by velocity

        cameraPosition.add(velocity);
        
      }
    

    // Flight (Needs work).



    if (isDown) {

        cameraPosition.y += 0.05f;
      }
    

    if (isUp) {

        cameraPosition.y -= 0.05f;
      }
    
  }
}
boolean isLeft, isRight, isUp, isDown, isForward, isBack,isBoost,isNoClip,isInfo,isStat; 

  float switchplanet=1;
boolean noclip=false;
boolean Stat=false;
public void keyPressed() {
  setMove(keyCode, true);
  setMove(key, true);
  if (key == CODED){
    if (keyCode == LEFT)  {
      switchplanet  = switchplanet - 1;
      if (switchplanet<= 0) switchplanet = 9;
    }
    if (keyCode == RIGHT) {
      switchplanet= switchplanet + 1;
      if (switchplanet>= 10) switchplanet = 1;
    }
  }
   if (key == 'v'){
    noclip=!noclip;}
   if (keyCode == 99){
    Stat=!Stat;}
  }
 
public void keyReleased() {
  setMove(keyCode, false);
  setMove(key, false);
}
 
public boolean setMove(int k, boolean b) {
  switch (k) {
  case ' ':
    return isUp = b;
 
  case CONTROL:
    return isDown = b;
  case SHIFT:
    return isBoost = b;
 
  case 'q':
    return isLeft = b;
 
  case 'd':
    return isRight = b;
    
    case 'z':
    return isForward = b;
     case 's':
    return isBack = b;
    case 'v':
    return isNoClip = b;
    
    case TAB:
    return isInfo = b;
    
 
  default:
    return b;
  }
}
class jupiter{
float distance;
float taille;
String texture;
float vitesse;
float yy;
 float yyy;
String nom;
jupiter(String nom,float distance, float taille, String texture, float vitesse, float yy){
  this.distance = distance;
  this.taille = taille;
  this.texture = texture;
  this.vitesse = vitesse;
  this.yy = yy;
  this.nom = nom;
}
float refresh=0;
public void setuptex(){ 
  if (refresh<1){
  refresh=refresh+1;
  jupitertex = loadImage(texture);
  jupiterS = createShape(SPHERE, taille);   
  jupiterS.setStroke(false);
  jupiterS.setTexture(jupitertex);}}

public void display(){
  setuptex();
  yy = yy+vitesse;
  rotateY(radians(yy));
  translate(distance,0,0);
  if(isInfo){
  stroke(255);
  fill(255);
  rotateY(-PI/2);
  textAlign(LEFT);
  textSize(80);
text (nom, taille*1.5f*2+20, -taille*1.5f+20);
line(0,0,taille*1.5f,-taille*1.5f);
line(taille*1.5f,-taille*1.5f,taille*1.5f*2,-taille*1.5f);
rotateY(PI/2);
noStroke();
noFill();}
  directionalLight(250, 250, 250, distance, 0, 0);
  yyy=yyy+0.05f;
  rotateY(radians(yyy));
  shape(jupiterS);
  if (nom =="jupiter"){
    luneJ1.ldisplay();
    luneJ2.ldisplay();
    luneJ3.ldisplay();
    luneJ4.ldisplay();
      }
  rotateY(radians(-yyy));
  translate(-distance,0,0);
  rotateY(radians(-yy));
  noLights();
   if (nom =="jupiter"){
     if (switchplanet == 6&&noclip==false){
       rotateX(radians(90));
       noFill();
       translate((width/2), (height/2), 0);
       HUD();
       textAlign(CENTER);
       textSize(40);
       text("<< "+nom+" >>",width/2,height-50);
       camera(camEyeX+distance*sin(radians(yy+90)), camEyeY, camEyeZ+distance*cos(radians(yy+90)), viewX+distance*sin(radians(yy+90)), viewY, viewZ+distance*cos(radians(yy+90)), camUpX, camUpY, camUpZ); 
  if (rho<taille*4){
    rho = taille*4;}
       updateCamPosition();
       translate((width/2), (height/2), 0);
       noStroke();
     }}
   }}
class sattelite{
float distance;
float taille;
String texture;
float vitesse;
float yy;
float pos;
sattelite(float distance, float taille, String texture, float vitesse, float yy,float pos){
  this.distance = distance;
  this.taille = taille;
  this.texture = texture;
  this.vitesse = vitesse;
  this.yy = yy;
  this.pos = pos;
}
  float refresh=0;
public void setuptex(){ 
  if (refresh<1){
  refresh=refresh+1;
  lunetex = loadImage(texture);
  luneS = createShape(SPHERE, taille);   
  luneS.setStroke(false);
  luneS.setTexture(lunetex);
}}
public void ldisplay(){
  setuptex();
  yy = yy+vitesse;
  if (pos == 1){
  rotateZ(radians(yy));
  translate(distance,0,0);
  shape(luneS);
  translate(-distance,0,0);
  rotateZ(radians(-yy));}
  if (pos == 2){
  rotateY(radians(yy));
  translate(distance,0,0);
  shape(luneS);
  translate(-distance,0,0);
  rotateY(radians(-yy));}
}}
class mars{
float distance;
float taille;
String texture;
float vitesse;
float yy;
 float yyy;
String nom;
mars(String nom,float distance, float taille, String texture, float vitesse, float yy){
  this.distance = distance;
  this.taille = taille;
  this.texture = texture;
  this.vitesse = vitesse;
  this.yy = yy;
  this.nom = nom;
}
float refresh=0;
public void setuptex(){ 
  if (refresh<1){
  refresh=refresh+1;
  marstex = loadImage(texture);
  marsS = createShape(SPHERE, taille);   
  marsS.setStroke(false);
  marsS.setTexture(marstex);}}

public void display(){
  setuptex();
  yy = yy+vitesse;
  rotateY(radians(yy));
  translate(distance,0,0);
  if(isInfo){
  stroke(255);
  fill(255);
  rotateY(-PI/2);
  textAlign(LEFT);
text (nom, taille*1.5f*2+3, -taille*1.5f+3);
line(0,0,taille*1.5f,-taille*1.5f);
line(taille*1.5f,-taille*1.5f,taille*1.5f*2,-taille*1.5f);
rotateY(PI/2);
noStroke();
noFill();}
  directionalLight(250, 250, 250, distance, 0, 0);
  yyy=yyy+0.1f;
  rotateY(radians(yyy));
  shape(marsS);
  if (nom =="terre"){
    lune.ldisplay();
      }
  rotateY(radians(-yyy));
  translate(-distance,0,0);
  rotateY(radians(-yy));
  noLights();
   if (nom =="mars"){
     if (switchplanet == 5&&noclip==false){
       rotateX(radians(90));
       noFill();
       translate((width/2), (height/2), 0);
       HUD();
       textAlign(CENTER);
       textSize(40);
       text("<< "+nom+" >>",width/2,height-50);
       camera(camEyeX+distance*sin(radians(yy+90)), camEyeY, camEyeZ+distance*cos(radians(yy+90)), viewX+distance*sin(radians(yy+90)), viewY, viewZ+distance*cos(radians(yy+90)), camUpX, camUpY, camUpZ); 
  if (rho<taille*4){
    rho = taille*4;}
       updateCamPosition();
       translate((width/2), (height/2), 0);
       noStroke();
     }}}}
class mercure{
float distance;
float taille;
String texture;
float vitesse;
float yy;
 float yyy;
String nom;
mercure(String nom,float distance, float taille, String texture, float vitesse, float yy){
  this.distance = distance;
  this.taille = taille;
  this.texture = texture;
  this.vitesse = vitesse;
  this.yy = yy;
  this.nom = nom;
}
float refresh=0;
public void setuptex(){ 
  if (refresh<1){
  refresh=refresh+1;
  mercuretex = loadImage(texture);
  mercureS = createShape(SPHERE, taille);   
  mercureS.setStroke(false);
  mercureS.setTexture(mercuretex);}}

public void display(){
  setuptex();
  yy = yy+vitesse;
  rotateY(radians(yy));
  translate(distance,0,0);
  if(isInfo){
  stroke(255);
  fill(255);
  rotateY(-PI/2);
  textAlign(LEFT);
text (nom, taille*1.5f*2+3, -taille*1.5f+3);
line(0,0,taille*1.5f,-taille*1.5f);
line(taille*1.5f,-taille*1.5f,taille*1.5f*2,-taille*1.5f);
rotateY(PI/2);
noStroke();
noFill();}
  directionalLight(250, 250, 250, distance, 0, 0);
  yyy=yyy+0.5f;
  rotateY(radians(yyy));
  shape(mercureS);
  if (nom =="terre"){
    lune.ldisplay();
      }
  rotateY(radians(-yyy));
  translate(-distance,0,0);
  rotateY(radians(-yy));
  noLights();
   if (nom =="mercure"){
     if (switchplanet == 2 &&noclip==false){
       rotateX(radians(90));
       noFill();
       translate((width/2), (height/2), 0);
       HUD();
       textAlign(CENTER);
       textSize(40);
       text("<< "+nom+" >>",width/2,height-50);
       camera(camEyeX+distance*sin(radians(yy+90)), camEyeY, camEyeZ+distance*cos(radians(yy+90)), viewX+distance*sin(radians(yy+90)), viewY, viewZ+distance*cos(radians(yy+90)), camUpX, camUpY, camUpZ); 
  if (rho<taille*4){
    rho = taille*4;}
       updateCamPosition();
       translate((width/2), (height/2), 0);
       noStroke();
     }}}}
class neptune{
float distance;
float taille;
String texture;
float vitesse;
float yy;
 float yyy;
String nom;
neptune(String nom,float distance, float taille, String texture, float vitesse, float yy){
  this.distance = distance;
  this.taille = taille;
  this.texture = texture;
  this.vitesse = vitesse;
  this.yy = yy;
  this.nom = nom;
}
float refresh=0;
public void setuptex(){ 
  if (refresh<1){
  refresh=refresh+1;
  neptunetex = loadImage(texture);
  neptuneS = createShape(SPHERE, taille);   
  neptuneS.setStroke(false);
  neptuneS.setTexture(neptunetex);}}

public void display(){
  setuptex();
  yy = yy+vitesse;
  rotateY(radians(yy));
  translate(distance,0,0);
  if(isInfo){
  stroke(255);
  fill(255);
  rotateY(-PI/2);
  textAlign(LEFT);
text (nom, taille*1.5f*2+20, -taille*1.5f+20);
line(0,0,taille*1.5f,-taille*1.5f);
line(taille*1.5f,-taille*1.5f,taille*1.5f*2,-taille*1.5f);
rotateY(PI/2);
noStroke();
noFill();}
  directionalLight(250, 250, 250, distance, 0, 0);
  yyy=yyy+0.05f;
  rotateY(radians(yyy));
  shape(neptuneS);
  if (nom =="terre"){
    lune.ldisplay();
      }
  rotateY(radians(-yyy));
  translate(-distance,0,0);
  rotateY(radians(-yy));
  noLights();
   if (nom =="neptune"){
     if (switchplanet == 9&&noclip==false){
       rotateX(radians(90));
       noFill();
       translate((width/2), (height/2), 0);
       HUD();
       textAlign(CENTER);
       textSize(40);
       text("<< "+nom+" >>",width/2,height-50);
       camera(camEyeX+distance*sin(radians(yy+90)), camEyeY, camEyeZ+distance*cos(radians(yy+90)), viewX+distance*sin(radians(yy+90)), viewY, viewZ+distance*cos(radians(yy+90)), camUpX, camUpY, camUpZ); 
  if (rho<taille*4){
    rho = taille*4;}
       updateCamPosition();
       translate((width/2), (height/2), 0);
       noStroke();
     }}}}
class saturne{
float distance;
float taille;
String texture;
float vitesse;
float yy;
 float yyy;
String nom;
saturne(String nom,float distance, float taille, String texture, float vitesse, float yy){
  this.distance = distance;
  this.taille = taille;
  this.texture = texture;
  this.vitesse = vitesse;
  this.yy = yy;
  this.nom = nom;
}
float refresh=0;
public void setuptex(){ 
  if (refresh<1){
  refresh=refresh+1;
  saturnetex = loadImage(texture);
  saturneS = createShape(SPHERE, taille);   
  saturneS.setStroke(false);
  saturneS.setTexture(saturnetex);}}

public void display(){
  setuptex();
  yy = yy+vitesse;
  rotateY(radians(yy));
  translate(distance,0,0);
  if(isInfo){
  stroke(255);
  fill(255);
  rotateY(-PI/2);
  textAlign(LEFT);
text (nom, taille*1.5f*2+20, -taille*1.5f+20);
line(0,0,taille*1.5f,-taille*1.5f);
line(taille*1.5f,-taille*1.5f,taille*1.5f*2,-taille*1.5f);
rotateY(PI/2);
noStroke();
noFill();}
  directionalLight(250, 250, 250, distance, 0, 0);
  yyy=yyy+0.05f;
  rotateY(radians(yyy));
  shape(saturneS);
  rotateY(radians(-yyy));
  if (nom =="saturne"){
    
  for(int i=0; i<=aste; i++){  
    asteroide.get(i).ldisplay();}
      }
  translate(-distance,0,0);
  rotateY(radians(-yy));
  noLights();
   if (nom =="saturne"){
     if (switchplanet == 7&&noclip==false){
       rotateX(radians(90));
       noFill();
       translate((width/2), (height/2), 0);
       HUD();
       textAlign(CENTER);
       textSize(40);
       text("<< "+nom+" >>",width/2,height-50);
       camera(camEyeX+distance*sin(radians(yy+90)), camEyeY, camEyeZ+distance*cos(radians(yy+90)), viewX+distance*sin(radians(yy+90)), viewY, viewZ+distance*cos(radians(yy+90)), camUpX, camUpY, camUpZ); 
  if (rho<taille*4){
    rho = taille*4;}
       updateCamPosition();
       translate((width/2), (height/2), 0);
       noStroke();
     }}}}
 class soleil{
  float taille;
  String texture;
  float yyy;
  String nom;
  soleil(String nom, float taille, String texture){
  this.taille = taille;
  this.texture = texture;
  this.nom = nom;
  }
  float refresh=0;
public void setuptex(){ 
  if (refresh<1){
  refresh=refresh+1;
  soleiltex = loadImage(texture);
  soleilS = createShape(SPHERE, taille);   
  soleilS.setStroke(false);
  soleilS.setTexture(soleiltex);
}}
   public void display(){
     
  
 
  
     setuptex();
  if (switchplanet == 1&&noclip==false){
       textAlign(CENTER);
       textSize(40);
       text("<< "+nom+" >>",width/2,height-50);
    camera(camEyeX, camEyeY, camEyeZ, viewX, viewY, viewZ, camUpX, camUpY, camUpZ);
    if (rho<taille*4){
    rho = taille*4;}
  updateCamPosition();
  }
  
  
  translate(width/2, height/2, 0);
  if(isInfo){
  stroke(255);
  textSize(40);
  fill(255);
  textAlign(LEFT);
text (nom, taille*1.5f*2+10, -taille*1.5f+10);
line(0,0,taille*1.5f,-taille*1.5f);
line(taille*1.5f,-taille*1.5f,taille*1.5f*2,-taille*1.5f);
  textSize(10);
noStroke();}
  shape(soleilS);
  
  
 }}
class terre{
float distance;
float taille;
String texture;
float vitesse;
float yy;
 float yyy;
String nom;
terre(String nom,float distance, float taille, String texture, float vitesse, float yy){
  this.distance = distance;
  this.taille = taille;
  this.texture = texture;
  this.vitesse = vitesse;
  this.yy = yy;
  this.nom = nom;
}
float refresh=0;
public void setuptex(){ 
  if (refresh<1){
  refresh=refresh+1;
  terretex = loadImage(texture);
  terreS = createShape(SPHERE, taille);   
  terreS.setStroke(false);
  terreS.setTexture(terretex);}}

public void display(){
  setuptex();
  yy = yy+vitesse;
  rotateY(radians(yy));
  translate(distance,0,0);
  if(isInfo){
    stroke(255);
    fill(255);
    rotateY(-PI/2);
  textAlign(LEFT);
    text (nom, taille*1.5f*2+3, -taille*1.5f+3);
    line(0,0,taille*1.5f,-taille*1.5f);
    line(taille*1.5f,-taille*1.5f,taille*1.5f*2,-taille*1.5f);
    rotateY(PI/2);
    noStroke();
    noFill();}
  directionalLight(250, 250, 250, distance, 0, 0);
  directionalLight(5, 5, 5, -distance, 0, 0);
  yyy=yyy+0.1f;
  rotateY(radians(yyy));
  shape(terreS);
  if (nom =="terre"){
    lune.ldisplay();
      }
  rotateY(radians(-yyy));
  translate(-distance,0,0);
  rotateY(radians(-yy));
  noLights();
   if (nom =="terre"){
     if (switchplanet == 4&&noclip==false){
       rotateX(radians(90));
       noFill();
       translate((width/2), (height/2), 0);
       HUD();
       textAlign(CENTER);
       textSize(40);
       text("<< "+nom+" >>",width/2,height-50);
       camera(camEyeX+distance*sin(radians(yy+90)), camEyeY, camEyeZ+distance*cos(radians(yy+90)), viewX+distance*sin(radians(yy+90)), viewY, viewZ+distance*cos(radians(yy+90)), camUpX, camUpY, camUpZ); 
  if (rho<taille*4){
    rho = taille*4;}
       updateCamPosition();
       translate((width/2), (height/2), 0);
       noStroke();
     }}}}
class uranus{
float distance;
float taille;
String texture;
float vitesse;
float yy;
 float yyy;
String nom;
uranus(String nom,float distance, float taille, String texture, float vitesse, float yy){
  this.distance = distance;
  this.taille = taille;
  this.texture = texture;
  this.vitesse = vitesse;
  this.yy = yy;
  this.nom = nom;
}
float refresh=0;
public void setuptex(){ 
  if (refresh<1){
  refresh=refresh+1;
  uranustex = loadImage(texture);
  uranusS = createShape(SPHERE, taille);   
  uranusS.setStroke(false);
  uranusS.setTexture(uranustex);}}

public void display(){
  setuptex();
  yy = yy+vitesse;
  rotateY(radians(yy));
  translate(distance,0,0);
  if(isInfo){
  stroke(255);
  fill(255);
  rotateY(-PI/2);
  textAlign(LEFT);
text (nom, taille*1.5f*2+20, -taille*1.5f+20);
line(0,0,taille*1.5f,-taille*1.5f);
line(taille*1.5f,-taille*1.5f,taille*1.5f*2,-taille*1.5f);
rotateY(PI/2);
noStroke();
noFill();}
  directionalLight(250, 250, 250, distance, 0, 0);
  yyy=yyy+0.05f;
  rotateY(radians(yyy));
  shape(uranusS);
  if (nom =="terre"){
    lune.ldisplay();
      }
  rotateY(radians(-yyy));
  translate(-distance,0,0);
  rotateY(radians(-yy));
  noLights();
   if (nom =="uranus"){
     if (switchplanet == 8&&noclip==false){
       rotateX(radians(90));
       noFill();
       translate((width/2), (height/2), 0);
       HUD();
       textAlign(CENTER);
       textSize(40);
       text("<< "+nom+" >>",width/2,height-50);
       camera(camEyeX+distance*sin(radians(yy+90)), camEyeY, camEyeZ+distance*cos(radians(yy+90)), viewX+distance*sin(radians(yy+90)), viewY, viewZ+distance*cos(radians(yy+90)), camUpX, camUpY, camUpZ); 
  if (rho<taille*4){
    rho = taille*4;}
       updateCamPosition();
       translate((width/2), (height/2), 0);
       noStroke();
     }}}}
class venus{
float distance;
float taille;
String texture;
float vitesse;
float yy;
 float yyy;
String nom;
venus(String nom,float distance, float taille, String texture, float vitesse, float yy){
  this.distance = distance;
  this.taille = taille;
  this.texture = texture;
  this.vitesse = vitesse;
  this.yy = yy;
  this.nom = nom;
}
float refresh=0;
public void setuptex(){ 
  if (refresh<1){
  refresh=refresh+1;
  venustex = loadImage(texture);
  venusS = createShape(SPHERE, taille);   
  venusS.setStroke(false);
  venusS.setTexture(venustex);}}

public void display(){
  setuptex();
  yy = yy+vitesse;
  rotateY(radians(yy));
  translate(distance,0,0);
  if(isInfo){
  stroke(255);
  fill(255);
  rotateY(-PI/2);
  textAlign(LEFT);
text (nom, taille*1.5f*2+3, -taille*1.5f+3);
line(0,0,taille*1.5f,-taille*1.5f);
line(taille*1.5f,-taille*1.5f,taille*1.5f*2,-taille*1.5f);
rotateY(PI/2);
noStroke();
noFill();}
  directionalLight(250, 250, 250, distance, 0, 0);
  yyy=yyy+0.1f;
  rotateY(radians(yyy));
  shape(venusS);
  if (nom =="terre"){
    lune.ldisplay();
      }
  rotateY(radians(-yyy));
  translate(-distance,0,0);
  rotateY(radians(-yy));
  noLights();
   if (nom =="venus"){
     if (switchplanet == 3&&noclip==false){
       rotateX(radians(90));
       noFill();
       translate((width/2), (height/2), 0);
       HUD();
       textAlign(CENTER);
       textSize(40);
       text("<< "+nom+" >>",width/2,height-50);
       camera(camEyeX+distance*sin(radians(yy+90)), camEyeY, camEyeZ+distance*cos(radians(yy+90)), viewX+distance*sin(radians(yy+90)), viewY, viewZ+distance*cos(radians(yy+90)), camUpX, camUpY, camUpZ); 
  if (rho<taille*4){
    rho = taille*4;}
       updateCamPosition();
       translate((width/2), (height/2), 0);
       noStroke();
     }}}}
  public void settings() {  size(1280, 720, P3D); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Universe" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
