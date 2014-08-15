
	javac -classpath .:gridworld.jar SparseGridNode.java
	javac -classpath .:gridworld.jar OccupantInCol.java
	javac -classpath .:gridworld.jar -Xlint:unchecked SparseBoundedGrid.java
	javac -classpath .:gridworld.jar -Xlint:unchecked SparseBoundedGrid2.java
	javac -classpath .:gridworld.jar SparseBoundedGrid3.java
	javac -classpath .:gridworld.jar -Xlint:unchecked UnboundedGrid2.java
	javac -classpath .:gridworld.jar SparseGridRunner.java
	java -classpath .:gridworld.jar SparseGridRunner
