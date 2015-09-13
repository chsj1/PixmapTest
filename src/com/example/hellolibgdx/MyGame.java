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
	TextureRegion bgRegion;//����ͼƬ
	
	@Override
	public void create() {
		batch = new SpriteBatch();
		texture = new Texture(1024, 1024, Format.RGBA8888);
		pixmap = new Pixmap(800, 480, Format.RGBA8888);
		pixmap.setColor(Color.BLUE);//����pixmap����ɫ
		pixmap.drawLine(0, 0, 100, 100);//��һ����
		pixmap.drawCircle(150, 150, 32);//��һ������Բ
		pixmap.drawRectangle(0, 0, 100, 100);//��һ�����ľ���
		pixmap.fillCircle(200, 200, 32);//��һ��ʵ��Բ
		pixmap.fillRectangle(0, 200, 50, 50);//��һ��ʵ�ľ���
		//ʹ��pixmap����һ��ͼ
		pixmap.drawPixmap(new Pixmap(Gdx.files.internal("data/image2.jpg")), 200, 0);
		//pixmap.getPixel(10, 240):��(10,240)������ص����ɫ(RGB8888����ʽ)
		System.out.println("--------->" + pixmap.getPixel(10, 240) );;
		pixmap.drawPixel(150, 10, 65535);//��(150,10)���������ص���ɫ����Ϊ��ɫ(��RGB8888�ĸ�ʽ)
		texture.draw(pixmap, 0, 0);	//��texture������һ��pixmapͼ��	
		region = new TextureRegion(texture,800,480);
		/**
		 * pixmap.getWidth()
		 * pixmap.getHeight()
		 * pixmap.getFormat()
		 * 
		 * ��ȡpixmap�����ǵĿ��ߡ���ʽ
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
