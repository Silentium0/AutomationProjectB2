package com.loop.test.day11_waits_pom;

import com.loop.pages.LoopPracticeDragDropPag;
import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class T1_Drag_drop_pom {


        /*
    Loop Practice Drag and Drop Test
    1. Open a chrome browser
    2. Go to: https://loopcamp.vercel.app/drag-and-drop-circles.html
    3. validate expected default text appears on big circle
    Expected = "Drag the small circle here."

    Loop Practice Drag and Drop Test
    1. Open a chrome browser
    2. Go to: https://loopcamp.vercel.app/drag-and-drop-circles.html
    3. Click and hold small circle
    4. validate "Drop here." text appears on big circle

    1. Open a chrome browser
    2. Go to: https://loopcamp.vercel.app/drag-and-drop-circles.html
    3. Click and hold small circle
    4. Move it on top of the big circle
    5. validate “Now drop…” text appears on big circ

    1. Open a chrome browser
    2. Go to: https://loopcamp.vercel.app/drag-and-drop-circles.html
    3. Click and hold small circle
    4. Dropped anywhere outside of big circle
    5. validate “Try again!” text appears on big circle

     */
        LoopPracticeDragDropPag   LoopPracticeDragDropPag;
         Actions actions;


    @BeforeMethod
    public void setUpMethod(){
        Driver.getDriver().get("https://loopcamp.vercel.app/drag-and-drop-circles.html");
        LoopPracticeDragDropPag = new LoopPracticeDragDropPag();
        actions = new Actions(Driver.getDriver());

    }
    @Test
    public void Drag_small_here_test(){
        String expected = "Drag the small circle here.";
        Assert.assertEquals(LoopPracticeDragDropPag.bigCircle.getText(),expected);
    }
    @Test
    public void drop_here(){
        actions.moveToElement(LoopPracticeDragDropPag.smallCircle)
                .clickAndHold()
                .moveByOffset(100,100)
                //.pause(2000)
                .perform();
        Assert.assertEquals(LoopPracticeDragDropPag.bigCircle.getText(),"Drop here.");

    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }




}
