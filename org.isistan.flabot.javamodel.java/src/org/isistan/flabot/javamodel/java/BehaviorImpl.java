/**

import java.lang.reflect.Member;

	private Member javaBehavior;
	
	Member getJavaBehavior() {
		return javaBehavior;
	}
	
	static Member getJavaMember(JBehavior jBehavior) {
		if(jBehavior instanceof BehaviorImpl) {
			return ((BehaviorImpl)jBehavior).getJavaBehavior();
		} else {
			throw new MixedImplementationsException(jBehavior);
		} 
	}
	
	BehaviorImpl(Member javaBehavior) {
		super(javaBehavior);
		this.javaBehavior=javaBehavior;
	}

}