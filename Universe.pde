import java.util.List;
soleil soleil = new soleil("soleil",40,"soleil.jpg");
terre terre = new terre("terre",500,11,"terre.jpg",0.2/100,random(0,360));
mercure mercure = new mercure("mercure",100,4,"mercure.jpg",0.5/100,random(0,360));
venus venus = new venus("venus",200,9,"venus.jpg",0.3/100,random(0,360));
mars mars = new mars("mars",700,8,"mars.jpg",0.1/100,random(0,360));
jupiter jupiter = new jupiter("jupiter",3000,100,"jupiter.jpg",0.05/100,random(0,360));
saturne saturne = new saturne("saturne",3500,80,"saturne.jpg",0.01/100,random(0,360));
uranus uranus = new uranus("uranus",4000,40,"uranus.jpg",0.005/100,random(0,360));
neptune neptune = new neptune("neptune",4500,40,"neptune.jpg",0.001/100,random(0,360));
sattelite lune = new sattelite(25,3,"lune.jpg",0.1,random(0,360),1);
sattelite luneJ1 = new sattelite(125,3,"lune.jpg",0.1,random(0,360),1);
sattelite luneJ2 = new sattelite(150,3,"lune.jpg",0.1,random(0,360),2);
sattelite luneJ3 = new sattelite(200,3,"lune.jpg",0.1,random(0,360),1);
sattelite luneJ4 = new sattelite(175,3,"lune.jpg",0.1,random(0,360),2);
List<HyperSpaceVisual> HSV = new ArrayList<HyperSpaceVisual>();

int stars= 200;

PImage cockpit;

void setup() {
  size(1280, 720, P3D);
  surface.setResizable(true);
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
     asteroide.add(new asteroide (random(100,135),1,"aste.jpg",0.01,random(0,360),2));}
  for(int i=0; i<=stars; i++){
  HSV.add(new HyperSpaceVisual (random(-width*1,width*2),random(-height*1,height*2),random(500,-5000),random(50,100)));}
  
}

void draw() {
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
 
      
