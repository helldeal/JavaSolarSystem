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

    topspeed = 0.2;
  }







  // All transformations applyed to the camera are here.

  void camTransformations() {

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
    rotateY(slidecam*0.01);



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

        acceleration.setMag(0.05);



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

        acceleration.setMag(0.05);
        

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

        acceleration.setMag(-0.05);



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

        acceleration.setMag(-0.05);



        // Velocity changes according to acceleration

        velocity.add(acceleration);

        // Limit the velocity by topspeed

        velocity.limit(topspeed);

        // Location changes by velocity

        cameraPosition.add(velocity);
        
      }
    

    // Flight (Needs work).



    if (isDown) {

        cameraPosition.y += 0.05;
      }
    

    if (isUp) {

        cameraPosition.y -= 0.05;
      }
    
  }
}
