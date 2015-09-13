package com.example.hellolibgdx;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class MyGame implements ApplicationListener {
	SpriteBatch batch;
	Texture texture;
	TextureRegion region;
	Pixmap pixmap;
	
	TextureAtlas atlas;
	TextureRegion bgRegion;//背景图片
	
	@Override
	public void create() {
		batch = new SpriteBatch();
		texture = new Texture(1024, 1024, Format.RGBA8888);
		pixmap = new Pixmap(800, 480, Format.RGBA8888);
		pixmap.setColor(Color.BLUE);//设置pixmap的颜色
		pixmap.drawLine(0, 0, 100, 100);//画一条线
		pixmap.drawCircle(150, 150, 32);//画一个空心圆
		pixmap.drawRectangle(0, 0, 100, 100);//画一个空心矩形
		pixmap.fillCircle(200, 200, 32);//画一个实心圆
		pixmap.fillRectangle(0, 200, 50, 50);//画一个实心矩形
		//使用pixmap来画一张图
		pixmap.drawPixmap(new Pixmap(Gdx.files.internal("data/image2.jpg")), 200, 0);
		//pixmap.getPixel(10, 240):把(10,240)这个像素点的颜色(RGB8888的形式)
		System.out.println("--------->" + pixmap.getPixel(10, 240) );;
		pixmap.drawPixel(150, 10, 65535);//将(150,10)这个点的像素的颜色设置为蓝色(以RGB8888的格式)
		texture.draw(pixmap, 0, 0);	//在texture上面套一个pixmap图层	
		region = new TextureRegion(texture,800,480);
		/**
		 * pixmap.getWidth()
		 * pixmap.getHeight()
		 * pixmap.getFormat()
		 * 
		 * 获取pixmap定义是的宽、高、格式
		 */
		System.out.println("----------->pixmap.getWidth(): " + pixmap.getWidth() + ",pixmap.getHeight() " + pixmap.getHeight()+ ",pixmap.getFormat()"+pixmap.getFormat());
	   
		atlas = new TextureAtlas(Gdx.files.internal("data/loading.atlas"));
		bgRegion = atlas.findRegion("bg");
	}
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
	}
	@Override
	public void pause() {
		// TODO Auto-generated method stub
	}
	@Override
	public void render() {
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(bgRegion, 0, 0);
		batch.draw(region, 0, 0);
		batch.end();
	}
	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub
	}
	@Override
	public void resume() {
		// TODO Auto-generated method stub
	}
}
