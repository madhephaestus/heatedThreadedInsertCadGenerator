import eu.mihosoft.vrl.v3d.parametrics.*;
CSG generate(){
	String type= "heatedThreadedInsert"
	if(args==null)
		args=["M5"]
	// The variable that stores the current size of this vitamin
	StringParameter size = new StringParameter(	type+" Default",args.get(0),Vitamins.listVitaminSizes(type))
	HashMap<String,Object> measurments = Vitamins.getConfiguration( type,size.getStrValue())

	def diameterValue = measurments.diameter
	def installLengthValue = measurments.installLength
	println "Measurment diameterValue =  "+diameterValue
	println "Measurment installLengthValue =  "+installLengthValue
	// Stub of a CAD object
	CSG part = new Cylinder(diameterValue/2,installLengthValue).toCSG()
	return part
		.setParameter(size)
		.setRegenerate({generate()})
}
return generate() 