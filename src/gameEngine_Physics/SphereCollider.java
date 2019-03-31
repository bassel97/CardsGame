package gameEngine_Physics;

public class SphereCollider extends Collider {

	float radius;

	public SphereCollider(float r) {
		colliders.add(this);

		radius = r;
	}

	@Override
	public boolean canCollideWith(Collider otherCollider) {
		
		if(otherCollider.getClass() == getClass()){
			SphereCollider otherSphereCollider = (SphereCollider)otherCollider;
			
			float sqrDistanceRs = (float) Math.pow(( gameObject.transform.position.x - otherSphereCollider.gameObject.transform.position.x),2);
			sqrDistanceRs += (float) Math.pow(( gameObject.transform.position.y - otherSphereCollider.gameObject.transform.position.y),2);
			sqrDistanceRs += (float) Math.pow(( gameObject.transform.position.z - otherSphereCollider.gameObject.transform.position.z),2);
			
			float twoRadiiSqr = (float) Math.pow(radius + otherSphereCollider.radius,2);
			
			return sqrDistanceRs < twoRadiiSqr;
		}

		return false;
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void end() {
		// TODO Auto-generated method stub

	}

}