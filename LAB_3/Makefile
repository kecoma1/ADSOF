all: compile test1 test2 clean #doc

compile:
	@echo "#-----------------------"
	@echo "Compiling . . ."
	@echo ""
	javac pr3/traffic/vehicles/*.java pr3/traffic/drivers/*.java pr3/traffic/fines/*.java
	@echo "\n"

clean:
	rm -f pr3/traffic/drivers/*.class
	rm -f pr3/traffic/vehicles/*.class
	rm -f pr3/traffic/fines/*.class
	rm -r -f doc

test1:
	@echo "#-----------------------"
	@echo "Executing Test 1 . . ."
	@echo ""
	java pr3.traffic.vehicles.TesterPr31
	@echo "\n"

exe2:
	@echo "#-----------------------"
	@echo "Executing Example2 . . ."
	@echo ""
	java pr3/traffic/Example2
	@echo "\n"

test2:
	@echo "#-----------------------"
	@echo "Executing Test 2 . . ."
	@echo ""
	java pr3.traffic.fines.FineTester
	@echo "\n"

doc:
	@echo "#-----------------------"
	@echo "Generating doc . . ."
	@echo ""
	javadoc -d doc -author pr3/traffic/drivers/*.java
	javadoc -d doc -author pr3/traffic/vehicles/*.java
	javadoc -d doc -author pr3/traffic/vehicles/*.java
	@echo "\n"
