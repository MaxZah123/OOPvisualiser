package C19452476;

import processing.core.PApplet;

import static processing.core.PConstants.HSB;

public class Loops {

    MaxVisual mv;
    float cy = 0;

    public Loops(MaxVisual mv) {
        this.mv = mv;
        cy = this.mv.height / 2;
    }


    private float angle1 = 0;//variables used for determining spin
    private float angle2 = 0;
    private float angle3 = 0;

    private float smoothedBoxSize = 0;
    private float angle = 0;

    private int f = 400;
    private int l = 2;
    private int k = 0;

    public Loops() {

    }

    public void render() {
        mv.camera(0, 0, l, 0, 0, -4, 0, 4, 0);
        mv.colorMode(HSB);
        //mv.background(255);// Set a background, messes everything up
        mv.noFill();// Shapes dont get filled
        mv.lights();
        mv.calculateAverageAmplitude();
        mv.stroke(PApplet.map(mv.getSmoothedAmplitude(), 1, 0, -1, 1), 255, 255);

        mv.translate(0, 0, -250);//Where objects will appear

        float boxSize = 100 + (mv.getAmplitude() * 300);
        smoothedBoxSize = PApplet.lerp(smoothedBoxSize, boxSize, 0.5f);

        if (k <= f)
        {
            mv.colorMode(HSB, 4);
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    mv.stroke(i, j, 4);
                    mv.point(i, j);
                    mv.pushMatrix();

                    mv.pushMatrix();
                    mv.rotateY(angle1);
                    mv.rotateX(angle1);
                    mv.strokeWeight(2.5f);
                    mv.circle(0, 0, smoothedBoxSize - 10);
                    mv.popMatrix();

                    mv.pushMatrix();
                    mv.rotateY(angle2);
                    mv.rotateX(angle2);
                    mv.strokeWeight(2.5f);
                    mv.circle(0, 0, smoothedBoxSize);
                    mv.popMatrix();

                    mv.pushMatrix();
                    mv.rotateY(angle3);
                    mv.rotateX(angle3);
                    mv.strokeWeight(2.5f);
                    mv.circle(0, 0, smoothedBoxSize + 10);
                    mv.popMatrix();
                    mv.popMatrix();

                    angle1 -= 0.01f;
                    angle2 += 0.02f;
                    angle3 += 0.005f;
                }
            }
            mv.colorMode(HSB, 2);
            for (int i = 0; i < 2; i++)//Sphere using HSB loop
            {
                for (int j = 0; j < 2; j++)
                {
                    mv.stroke(i, j, 2);
                    mv.point(i, j);
                    mv.rotateX(angle);
                    mv.rotateZ(angle);
                    float sphereSize = 13 + (100 * mv.getSmoothedAmplitude());//Determine sphere size and reactivness
                    mv.sphere(sphereSize);//calls sphere
                    angle += 0.02f;//sphere spin speed
                }
            }
        }
    }
}