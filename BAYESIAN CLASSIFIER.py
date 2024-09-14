import numpy as np
from sklearn.datasets import load_iris
from sklearn.model_selection import train_test_split
from sklearn.naive_bayes import GaussianNB
from sklearn.metrics import accuracy_score, classification_report
# Load dataset (Iris dataset in this case)
data = load_iris()
X = data.data
y = data.target
# Split dataset into training and testing sets
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.3, random_state=42)
# Initialize Gaussian Naive Bayes classifier
gnb = GaussianNB()
# Train the classifier
gnb.fit(X_train, y_train)
# Make predictions on the test set
y_pred = gnb.predict(X_test)
# Evaluate the classifier
accuracy = accuracy_score(y_test, y_pred)
report = classification_report(y_test, y_pred, target_names=data.target_names)
print(f"Accuracy: {accuracy:.2f}")
print("Classification Report:")
print(report)