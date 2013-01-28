/**


import java.io.IOException;
	/**
	 * Name of the gauge manager pool class
	 */
	private static final String GAUGE_MANAGER_POOL_CLASS_NAME=GaugeManagerPool.class.getName();
	
	/**
	 * Strategies to be instrumented 
	 */
	private Strategy[] strategies;
	

	/**
	 * Constructor 
	 * @param strategies
	 */
	public StrategyInstrumentor(Strategy[] strategies, boolean enabled) {
		this.strategies=strategies;
	}
	static class GaugeConsumerFilterResult {
	
	@Override
	public byte[] instrument(ClassLoader loader, String className, byte[] bytecode) throws InstrumentationException {
		try {
			ctClass=JavassistUtils.getCtClass(loader, className, bytecode);
		} catch (NotFoundException e) {
			String message="Class not found " + className;
			throw new InstrumentationException(message, e);
		}
		boolean modified=false;
		for(CtBehavior behavior: behaviors) {
				if(!gaugeConsumersBehaviorSubset.isEmpty()) {
						modified=modified | new GaugeAllocator().instrument(behavior, gaugeConsumersBehaviorSubset, loader, className, jPackage, jClass, jBehavior);
						String message="Compilation error at " + className + "." + behavior.getName() + "()";
						throw new org.isistan.flabot.instrumentation.classloader.InstrumentationException(message, e);
					} catch (NotFoundException e) {
						String message="Javassist class not found " + className;
						throw new org.isistan.flabot.instrumentation.classloader.InstrumentationException(message, e);
					}
				}
			}
		}

		if(!modified)
			return null;
		try {
			return ctClass.toBytecode();
		} catch (IOException e) {
			String message="IO error while generating bytecode for " + className;
			throw new InstrumentationException(message, e);
		} catch (CannotCompileException e) {
			String message="Compilation error at " + className;
			throw new InstrumentationException(message, e);
		}
		
	}

	private boolean isValidClass(CtClass ctClass) {
	private GaugeConsumer[] getAllGaugeConsumers() {
		if(this.allGaugeConsumers==null) {
			List<GaugeConsumer> allGaugeConsumers=new LinkedList<GaugeConsumer>();
			for(Strategy strategy: strategies) {
				GaugeConsumer[] gaugeConsumers=strategy.getGaugeConsumers();
				for(GaugeConsumer gaugeConsumer: gaugeConsumers) {
					allGaugeConsumers.add(gaugeConsumer);
				}
			}
			this.allGaugeConsumers = allGaugeConsumers.toArray(new GaugeConsumer[allGaugeConsumers.size()]);
		return this.allGaugeConsumers;
	}
	
	 * Returns all interested gauge consumers for the given gauge prototype
	 * @param gaugePrototype
	 * @return
	 */
	private GaugeConsumerFilterResult getPackageGaugeConsumers(JPackage jPackage) {
			try {
					result.addConfirmed(gaugeConsumer);
		return result;
	
	/**
	 * Determines is a method can be instrumented
	 * @param method
	 * @return
	 */
	private boolean isEditable(CtBehavior behavior) {
		int modifiers=behavior.getModifiers();
		return !Modifier.isAbstract(modifiers) &&
				!Modifier.isNative(modifiers);
	}

	/**
	private GaugeConsumerFilterResult getClassGaugeConsumers(JClass jClass, GaugeConsumerFilterResult packgeSubset) {
	/**
	 * Returns all interested gauge consumers for the given behavior
	 * @param gaugePrototype
	 * @return
	 */
	private GaugeConsumerFilterResult getBehaviorGaugeConsumers(JBehavior jBehavior, GaugeConsumerFilterResult classSubset) {
	 * Method body visitor used to insert gauges where the gauge consumers are interested in
	 * @author $Author: dacostae $
	 *
	 */
	class GaugeAllocator extends ExprEditor {
		
		private boolean modified=false;
		private GaugeConsumerFilterResult behaviorSubset;
		private ClassLoader loader;
		private String className;
		
		/**
		 * Allocated gauges if required 
		 * @param behavior
		 * @return All allocated gauges
		 * @throws CannotCompileException 
		 * @throws NotFoundException 
		 */
		public boolean instrument(CtBehavior behavior, GaugeConsumerFilterResult behaviorSubset, ClassLoader loader,
			this.loader=loader;
			this.className=className;
			edit(behavior, modified);
			return modified;
		}
		
		
		/**
		
		/**
}