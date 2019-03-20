package viewModule;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

public class GE_Window {

	long windowId;

	String windowTitle;

	int width;
	int height;

	boolean isFullScreen;

	public GE_Window() {
		windowTitle = "New Window";

		width = 800;
		height = 600;

		isFullScreen = false;
	}

	public GE_Window(String windowTitle, int width, int height, boolean isFullScreen) {
		this.windowTitle = windowTitle;

		this.width = width;
		this.height = height;

		this.isFullScreen = isFullScreen;
	}

	/*
	 * Initialize and show the window.
	 */
	public void init() {
		if (!GLFW.glfwInit()) {
			System.err.println("Couldn't initialize glfw");
			System.exit(-1);
		}

		GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GLFW.GLFW_FALSE);
		GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_FALSE);

		windowId = GLFW.glfwCreateWindow(width, height, windowTitle, isFullScreen ? GLFW.glfwGetPrimaryMonitor() : 0,
				0);

		if (windowId == 0) {
			System.err.println("Couldn't initialize glfw");
			System.exit(-1);
		}

		GLFW.glfwMakeContextCurrent(windowId);
		GL.createCapabilities();

		GLFWVidMode videoMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
		GLFW.glfwSetWindowPos(windowId, (videoMode.width() - width) / 2, (videoMode.height() - height) / 2);

		GLFW.glfwShowWindow(windowId);
	}

	public boolean shouldClose() {
		return GLFW.glfwWindowShouldClose(windowId);
	}

	public void draw() {
		GL11.glClearColor(0.0f, 0.0f, 0.65f, 1.0f);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);

		GLFW.glfwPollEvents();
	}

	public void swapBuffers() {
		GLFW.glfwSwapBuffers(windowId);
	}
	
	public void stop() {
		GLFW.glfwTerminate();
	}

}