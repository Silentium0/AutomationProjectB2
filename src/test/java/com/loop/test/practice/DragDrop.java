package com.loop.test.practice;

import com.loop.pages.LoopPracticeDragDropPag;
import com.loop.test.base.TestBase;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragDrop  {
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
    LoopPracticeDragDropPag dragDrop;
    Actions actions;


    @Test
    public void testDragDrop() {
        Driver.getDriver().get("https://loopcamp.vercel.app/drag-and-drop-circles.html");
        dragDrop = new LoopPracticeDragDropPag();
        Assert.assertEquals(dragDrop.bigCircle.getText(), "Drag the small circle here.");


    }
    @Test
    public void testDragDrop2()  {
        Driver.getDriver().get("https://loopcamp.vercel.app/drag-and-drop-circles.html");
        dragDrop = new LoopPracticeDragDropPag();
        actions = new Actions(Driver.getDriver());
        actions.moveToElement(dragDrop.smallCircle)
                .clickAndHold()
                .moveByOffset(100,100)
                .perform();
        Assert.assertEquals(dragDrop.bigCircle.getText(),"Drop here.");
//        actions.dragAndDrop(dragDrop.smallCircle,dragDrop.bigCircle).perform();
//        Assert.assertEquals(dragDrop.bigCircle.getText(),"You did great!");




    }
    @Test
    public void testDragDrop3()  {
        Driver.getDriver().get("https://loopcamp.vercel.app/drag-and-drop-circles.html");
        dragDrop = new LoopPracticeDragDropPag();
        actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(dragDrop.smallCircle,dragDrop.bigCircle).perform();
        Assert.assertEquals(dragDrop.bigCircle.getText(),"You did great!");

    }





}
