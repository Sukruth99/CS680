In machine learning we usually have different types of loss functions.
Every loss function takes predictions and targets, and returns a los for that.
In general there are so many types of loss functions, here we have mentioned a couple
Mean absolute error, means squared, Binary cross entropy

We have defined training data class which takes in predictions and targets.

The TrainingData class encapsulates the predictions and targets data for a training dataset. It has two member variables:
predictions: A double array representing the predicted values.
targets: A double array representing the target values.
The class has a constructor TrainingData(double[] predictions, double[] targets) that allows you to initialize the predictions and targets arrays.
The TrainingData class also has a loss method that takes a LossFunction object as a parameter. This method calculates the loss using the provided LossFunction implementation. The loss method internally calls the loss method of the LossFunction object and passes the predictions and targets arrays to it. The calculated loss value is then returned.
The loss method allows flexibility in calculating different types of losses by accepting different implementations of the LossFunction interface. The LossFunction interface defines a loss method that takes two double arrays (predictions and targets) and returns the calculated loss value.
The purpose of this design is to separate the calculation of the loss from the TrainingData class and allow different loss functions to be used interchangeably by implementing the LossFunction interface. This promotes flexibility and modularity in the codebase, enabling easy extension and customization of loss functions without modifying the TrainingData class.

We have used Strategy design pattern for here.