package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject{

	private Handler handler;

	public BasicEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);

		this.handler = handler;

		velX = 5;
		velY = 5;
		
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 16, 16);
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;

		if (y <= 0 || y >= Game.HEIGHT - 16) velY *= -1;
		if (x <= 0 || x >= Game.WIDTH - 16) velX *= -1;

		handler.addObject(new Trail(x, y, ID.Trail, Color.RED, 16, 16, 0.05f, handler));
		// handler.addObject(new Trail(x, y, ID.Trail, Color.WHITE, 16, 16, .25f, handler));
	}

	@Override
	public void render(Graphics g) {
		// g.setColor(Color.RED);
		// g.fillRect(x, y, 16, 16);
	}
	
}
