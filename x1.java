float x, y;       // Position of creature.
float dx, dy;     // Speed.
float horizon;
int speed=1, radx=80, rady=40;

//// SETUP:  window size, initialization (start in middle of screen).
void setup() {
  size( 600,500);
  horizon=  height/2;
  x=  100;
  y=  100;
  dx=  1.5;
  dy=  1.75;
}

//// NEXT FRAME:  scene, action, show.
void draw() {
  background();
  tree();
  apples();
  house();
  text();
  move();
  bird();
}
  
  
  //// SCENE:  sky, sun, tree, house, etc.
  void background(){
  background( 41,172,240);                  // sky
  fill( 255,255,0 );
  stroke(255,255,0);
  ellipse( width*1/32, height/16, 100,100 );    // sun
  fill( 50,247,127 );
  stroke(50,247,127);                       // Grass
  rect( 0,horizon, width,height*3/4 );      // Grass.
  }
 
  
  void tree(){
  fill(188, 110, 82);
  stroke(188,110,82);
  rect( 150, 200, 50, 150);     //tree
  stroke(50,247,127);
  fill(50,247,127);
  ellipse( 175,150, 160,160);
  }
  
  void apples(){
  fill(255,0,0);
  ellipse( 175,100, 30,30);
  ellipse( 150,130, 20,20);
  ellipse( 190,160, 25,25);
  ellipse( 200,190, 20,20);
  ellipse( 200,130, 30,30);
  ellipse( 150,200, 20,20);
  ellipse( 140,170, 25,25);
  }
 
 
 
 void house(){
 stroke(162,167,165);
 fill(162,167,165);
 rect(350,150, 200,150);    
 triangle(320,150, 580,150, 450,80); //roof
 rect(370,90,30,50);
 fill(255);
 stroke(255);
 ellipse(360,70, 50,30);
 ellipse(340,50, 60,35);
 
 //window
 fill(255);
 stroke(0);
 rect(450,150, 60,60);
 stroke(0);
 line(480,150, 480,210);
 line(450,180, 510,180);
 
 //door
 fill(188, 110, 82);
 stroke(188, 110, 82);
 rect(380,220, 50,80);
 fill(255,255,0);
 stroke(255,255,0);
 ellipse(390,260, 15,15);
 }
 
 
 void text(){
 fill(0);
 text( "Teng Lin", 10,height-20 ); 
 
 }
                                           
                                            
  //// ACTION:  move (x,y) coordinates.
  void move(){
  x=  x + 1*dx;
  y=  y + 1*dy;
  
  if (x > width-radx || x < radx) {
    dx *=-1;
  }
  if (y > horizon-20 || y < rady) {
    dy *=-1;
  }
  
  
  }
  //// SHOW:  display the creature at (x,y)

  void bird(){
  fill(0,0,255);
  stroke(0,0,255);
  ellipse( x,y, radx,rady );
  triangle( x,y-10, x, y+10, x+60, y+5);
  triangle(x+10,y+10, x-50,y-20, x-50, y+20);
  fill(0);
  text( "Fred", x-20,y );
  ellipse(x+20, y-5, 5,5);

}





//////// HANDLERS:  mouse clicks, keys
void mousePressed() {
  //x=  mouseX;                             // Set (x,y) to mouse
  //y=  mouseY;
  //
  dx=  random( -2, +3 );                  // random speed.
  dy=  random( -2, +3 );
}

void keyPressed() {
  if (key == 'q') {
    exit();                           // press 'q' key to QUIT.
  }
}
