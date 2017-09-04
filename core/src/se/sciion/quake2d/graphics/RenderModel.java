package se.sciion.quake2d.graphics;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Matrix4;

/**
 * Wrapper around render methods using primitives.
 * Not very nice!
 * @author sciion
 *
 */
public class RenderModel {

	public ShapeRenderer primitiveRenderer;
	
	public RenderModel(){
		primitiveRenderer = new ShapeRenderer();
		primitiveRenderer.setAutoShapeType(true);
	}
	
	
	public void begin(){
		primitiveRenderer.begin();
	}
	
	
	public void end(){
		primitiveRenderer.end();
	}

	public void setProjectionMatrix(Matrix4 combined) {
		primitiveRenderer.setProjectionMatrix(combined);
	}
}
