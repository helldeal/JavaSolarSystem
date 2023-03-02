void drawAxis(){
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
