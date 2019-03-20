package gameEngine_core;

import java.util.ArrayList;

public class GameObject {

	public static ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();

	public final Transform transform = new Transform();

	public String name;

	private ArrayList<Component> components = new ArrayList<>();

	public GameObject() {
		gameObjects.add(this);
	}

	public void start() {
		for (Component component : components) {
			component.start();
		}
	}

	public void update() {
		for (Component component : components) {
			component.update();
		}
	}

	public GameObject(String name) {
		this.name = name;
	}

	public void addComponent(Component component) {
		components.add(component);
		
		component.gameObject = this;
	}

}