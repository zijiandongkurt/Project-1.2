package com.badlogic.terrain;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.decals.CameraGroupStrategy;
import com.badlogic.gdx.graphics.g3d.decals.Decal;
import com.badlogic.gdx.graphics.g3d.decals.DecalBatch;
import com.badlogic.gdx.graphics.g3d.utils.MeshBuilder;
import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g3d.*;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.model.Node;
import com.badlogic.gdx.graphics.g3d.shaders.DefaultShader;
import com.badlogic.gdx.graphics.g3d.utils.MeshBuilder;
import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Vector3;
import sun.security.provider.certpath.Vertex;

import java.util.ArrayList;
import java.util.Arrays;



public class TerrainTest extends ApplicationAdapter implements InputProcessor {
//	SpriteBatch batch;
//	Texture img;


	//private PerspectiveCamera camera;
	private float ff;
	private ModelBatch modelBatch;
	private Environment environment;
	private PerspectiveCamera camera;


	private ModelBuilder modelBuilder;
	private ModelInstance modelInstance;
	private ModelInstance modelInstanceBox;
	private Model model;
	private Model box;
	@Override
	public void create () {
		float[] ff = verticeList2();
		modelBatch =  new ModelBatch();
		environment = new Environment();

		camera = new PerspectiveCamera(75,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		camera.position.set(1f,1f,3f);
		camera.lookAt(0f,0f,0f);
		camera.near  = 1f;
		camera.far = 300f;

		DirectionalLight dLight = new DirectionalLight();
		Color     lightColor = new Color(0.75f, 0.75f, 0.75f, 1);
		Vector3  lightVector = new Vector3(-1.0f, -0.75f, -0.25f);
		dLight.set( lightColor, lightVector );

		environment = new Environment();
		environment.set(new ColorAttribute(ColorAttribute.AmbientLight,0.8f,0.8f,0.8f,1f));
		environment.add( dLight );

		modelBuilder = new ModelBuilder();
		modelBuilder.begin();
		MeshPartBuilder mb1;
		Material material = new Material(ColorAttribute.createDiffuse(Color.FOREST));
		mb1 =modelBuilder.part("part1", GL30.GL_TRIANGLES, VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal, material);
		mb1.setColor(Color.BLACK);



		int count = 0;
		while(count<ff.length-1){
			MeshPartBuilder.VertexInfo va = new MeshPartBuilder.VertexInfo().setPos(ff[count],ff[count+1],ff[count+2]).setNor(0, 0, 0).setCol(Color.FOREST).setUV(0.5f, 0.0f);
			count+=3;
			MeshPartBuilder.VertexInfo vb = new MeshPartBuilder.VertexInfo().setPos(ff[count],ff[count+1],ff[count+2]).setNor(0, 0, 1).setCol(Color.RED).setUV(0.0f, 0.0f);
			count+=3;
			MeshPartBuilder.VertexInfo vc = new MeshPartBuilder.VertexInfo().setPos(ff[count],ff[count+1],ff[count+2]).setNor(0, 0, 1).setCol(Color.FOREST).setUV(0.0f, 0.5f);
			count+=3;
			//mb1.tr

			mb1.triangle(va,vb,vc);
		}
		model = modelBuilder.end();
		modelInstance = new ModelInstance(model,0,0,0);


	//	modelBuilder.begin();
		box = modelBuilder.createBox(1f,1f,1f,
				new Material(ColorAttribute.createDiffuse(Color.BLUE)),
				VertexAttributes.Usage.Position|VertexAttributes.Usage.Normal);
	//	modelInstanceBox = new ModelInstance(box,0,0,0);
	//	modelBuilder.end();
		Gdx.input.setInputProcessor(this);

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.5f,0.5f,0.5f,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT|GL20.GL_DEPTH_BUFFER_BIT);


		camera.update();
		modelBatch.begin(camera);

		modelBatch.render(modelInstance,environment);
//		modelBatch.render(modelInstanceBox,environment);

		modelBatch.end();
	}
	
	@Override
	public void dispose () {

	}





	public float[] verticeList2 (){
		float range = 10;
		float accuracy = 0.05f;

		int size = (int)(range/accuracy+1)*(int)(range/accuracy+1)*3;
		//	matrix = new int[(int) (range/accuracy)][(int) (range/accuracy)];
		float[] ff = new float[size];

		float x = -1*range, y = -1*range;

		int count = 0;
		while(x<range && count<size){
			while(y<range && count<size){
				ff[count]=x;
				count++;
				ff[count]=y;
				count++;
				ff[count]=heightFunction(x,y);
				y++;
				count++;

			}
			x+=accuracy;
			y=-1*range;
		}

		return ff;
	}


	public float heightFunction(float x, float y){
		return (x*x+y*y)/5;

		//return x+1;
	}

	@Override

	public boolean keyDown(int keycode) {
		//in the real world , do not creat NEW variable over and over,
		// a temporary static member instead;
		if(keycode == Input.Keys.LEFT)
			camera.rotateAround(new Vector3(0f,0f,0f),new Vector3(0f,1f,0f),10f );

		if(keycode == Input.Keys.RIGHT)
			camera.rotateAround(new Vector3(0f,0f,0f),new Vector3(0f,1f,0f),-10f );

		if(keycode == Input.Keys.UP)
			camera.rotateAround(new Vector3(0f,0f,0f),new Vector3(1f,0f,0f),10f );
		if(keycode == Input.Keys.DOWN)
			camera.rotateAround(new Vector3(0f,0f,0f),new Vector3(1f,0f,0f),-10f );
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(float amountX, float amountY) {
		return false;
	}
}
