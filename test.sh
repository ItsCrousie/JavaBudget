#!/bin/bash

# Exit immediately if any command fails
set -e

# Paths
SRC_DIR="src"
TEST_DIR="test"
BIN_DIR="bin"
LIB_DIR="lib"
JUNIT_JAR="$LIB_DIR/junit-platform-console-standalone-1.10.0.jar"

# Step 1: Clean bin/
echo "Cleaning bin/ directory..."
rm -rf "$BIN_DIR"
mkdir -p "$BIN_DIR"

# Step 2: Compile source files
echo "Compiling source files..."
find "$SRC_DIR" -name "*.java" > sources.txt
javac -d "$BIN_DIR" -cp "$BIN_DIR" @sources.txt

# Step 3: Compile test files
echo "Compiling test files..."
find "$TEST_DIR" -name "*.java" > tests.txt
javac -d "$BIN_DIR" -cp "$BIN_DIR:$JUNIT_JAR" @tests.txt

# Step 4: Run tests
echo "Running tests..."
java -jar "$JUNIT_JAR" -cp "$BIN_DIR" --scan-classpath --details tree

# Cleanup
rm sources.txt tests.txt
