# **************************************************************************** #
#                                                                              #
#                                                         :::      ::::::::    #
#    Makefile                                           :+:      :+:    :+:    #
#                                                     +:+ +:+         +:+      #
#    By: ffloris <marvin@42.fr>                     +#+  +:+       +#+         #
#                                                 +#+#+#+#+#+   +#+            #
#    Created: 2018/04/13 09:39:19 by ffloris           #+#    #+#              #
#    Updated: 2018/10/20 19:43:47 by ffloris          ###   ########.fr        #
#                                                                              #
# **************************************************************************** #

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

SRC = ComputorV1 Utility \
	Variable Equation \
	EquationTokenizer Token TokenPattern TokenType \
	EquationParser ParserException \
	IEquationSolver EquationSolver \
	LinearEquationSolver QuadraticEquationSolver CubicEquationSolver
SRC := $(addprefix $(SRC_DIR)/, $(addsuffix .java, $(SRC)))

TEST_SRC = VariableTest EquationTest \
	EquationParserTest EquationSolverTest
TEST_SRC_WIDTH_DIR = $(addprefix $(TEST_DIR)/, $(addsuffix .java, $(TEST_SRC)))

GREEN_COLOR = "\033[0;32m"
YELLOW_COLOR = "\033[0;33m"
RED_COLOR = "\033[0;31m"
DEFAULT_COLOR = "\033[0m"

all: compile

tests: compile
	@javac -cp $(JUNIT_JAR):$(SRC_CLASS_DIR) -d $(TEST_CLASS_DIR) $(TEST_SRC_WIDTH_DIR)
	@java -cp $(JUNIT_JAR):$(HAMCREST_JAR):$(TEST_CLASS_DIR):$(SRC_CLASS_DIR) $(JUNIT_MAIN) $(TEST_SRC)

compile: $(CLASS_DIRS)
	@printf $(YELLOW_COLOR)
	@printf "Compiling... "
	@printf $(RED_COLOR)
	@javac -d $(SRC_CLASS_DIR) $(SRC)
	@printf $(GREEN_COLOR)
	@printf "[OK]\n"
	@printf $(DEFAULT_COLOR)

$(CLASS_DIRS):
	@mkdir -p $(CLASS_DIRS)

clean:
	@printf $(YELLOW_COLOR)
	@printf "Cleaning... "
	@printf $(RED_COLOR)
	@rm -rf $(CLASS_DIR)
	@printf $(GREEN_COLOR)
	@printf "[OK]\n"
	@printf $(DEFAULT_COLOR)

re: clean all

.PHONY: all tests compile clean re
