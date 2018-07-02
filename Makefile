EXT_DIR = ext

JUNIT_JAR = $(EXT_DIR)/junit-4.12.jar
JUNIT_MAIN = org.junit.runner.JUnitCore

HAMCREST_JAR = $(EXT_DIR)/hamcrest-core-1.3.jar

CLASS_DIR = class
TEST_CLASS_DIR = $(CLASS_DIR)/test
SRC_CLASS_DIR = $(CLASS_DIR)/src
CLASS_DIRS = $(TEST_CLASS_DIR) $(SRC_CLASS_DIR)

SRC_DIR = src
TEST_DIR = test

TEST_FILES = $(patsubst $(TEST_DIR)/%.java, %,$(shell find $(TEST_DIR) -name '*.java'))

GREEN_COLOR = "\033[0;32m"
YELLOW_COLOR = "\033[0;33m"
RED_COLOR = "\033[0;31m"
DEFAULT_COLOR = "\033[0m"

all: compile

tests: compile
	@javac -cp $(JUNIT_JAR):$(SRC_CLASS_DIR) -d $(TEST_CLASS_DIR) $(TEST_DIR)/*.java
	@java -cp $(JUNIT_JAR):$(HAMCREST_JAR):$(TEST_CLASS_DIR):$(SRC_CLASS_DIR) $(JUNIT_MAIN) $(TEST_FILES)

compile: $(CLASS_DIRS)
	@printf $(YELLOW_COLOR)
	@printf "Compiling... "
	@printf $(RED_COLOR)
	@javac -d $(SRC_CLASS_DIR) $(SRC_DIR)/*.java
	@printf $(GREEN_COLOR)
	@printf "[OK]\n"
	@printf $(DEFAULT_COLOR)

$(CLASS_DIRS):
	@mkdir -p $(CLASS_DIRS)

clean:
	@printf $(YELLOW_COLOR)
	@printf "Cleaning... "
	@printf $(RED_COLOR)
	@rm -rf $(CLASS_DIRS) $(CLASS_DIR)
	@printf $(GREEN_COLOR)
	@printf "[OK]\n"
	@printf $(DEFAULT_COLOR)

re: clean all

.PHONY: all tests compile clean re
