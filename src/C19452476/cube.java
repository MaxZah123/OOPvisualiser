

package C19452476;
import static processing.core.PConstants.HSB;

public class cube {
    MaxVisual mv;


    public cube(MaxVisual mv) {
        this.mv = mv;

    }

    private float angle = 0;

    public cube() {

    }


    public void render() {
        mv.noStroke();
        //mv.background(0);
        mv.colorMode(HSB, 9);//Creates rainbow effect
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                mv.stroke(i, j, 9);
                mv.point(i, j);

                mv.strokeWeight(1);//How thick the lines will be
                mv.lights();
                mv.pushMatrix();
                mv.camera(0, 0, 0, 0, 0, -1, 0, 1, 0);//Where we will see the box
                mv.translate(0, 0, -250);//Where box will appear
                mv.rotateX(angle);//rotates box
                mv.rotateZ(angle);//rotates box
                float boxSize = 340 + (800 * mv.getSmoothedAmplitude()); //Change box size and reactivness to music
                mv.box(boxSize);//calls box
                mv.popMatrix();
                angle += 0.02f;//How fast the box rotates
            }
        }
    }
}


