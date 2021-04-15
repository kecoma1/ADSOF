all: compile clean doc

compile:
	@echo "#-----------------------"
	@echo "Compiling . . ."
	@echo "#-----------------------"
	@echo ""
	javac pr4/vehicles/*.java pr4/exceptions/*.java pr4/races/*.java tests/*.java
	@echo "\n"

clean:
	rm -f pr3/traffic/drivers/*.class
	rm -f pr3/traffic/vehicles/*.class
	rm -f pr3/traffic/fines/*.class
	rm -f pr3/traffic/license/*.class
	rm -f pr3/traffic/tests/*.class
	rm -f pr3/traffic/itvs/*.class
	rm -r -f doc

test1:
	@echo "#-----------------------"
	@echo "Executing Test 1 . . ."
	@echo "#-----------------------"
	@echo ""
	@java pr3.traffic.vehicles.TesterPr31
	@echo "\n"

test2:
	@echo "#-----------------------"
	@echo "Executing Test 2 . . ."
	@echo "#-----------------------"
	@echo ""
	@java pr3.traffic.fines.FineTester
	@echo "\n"

test3:
	@echo "#-----------------------"
	@echo "Executing Test 3 . . ."
	@echo "#-----------------------"
	@echo ""
	@java pr3.traffic.license.TesterLicense
	@echo "\n"

test4:
	@echo "#-----------------------"
	@echo "Executing Test 4 . . ."
	@echo "#-----------------------"
	@echo ""
	@java pr3.traffic.fines.TesterFines
	@echo "\n"

test5:
	@echo "#-----------------------"
	@echo "Executing Test 5 . . ."
	@echo "#-----------------------"
	@echo ""
	@java pr3.traffic.itvs.TesterITV
	@echo "\n"

exe1:
	@echo "#-----------------------"
	@echo "Executing Example1 of previous assignment . . ."
	@echo "#-----------------------"
	@echo ""
	@java pr3.traffic.tests.Example1
	@echo "\n"

exe2:
	@echo "#-----------------------"
	@echo "Executing Example2 of previous assignment . . ."
	@echo "#-----------------------"
	@echo ""
	@java pr3.traffic.tests.Example2
	@echo "\n"

doc:
	@echo "#-----------------------"
	@echo "Generating doc . . ."
	@echo "#-----------------------"
	@echo ""
	javadoc -d ../doc -author pr4/exceptions/*.java pr4/races/*.java pr4/vehicles/*.java
	@echo "\n"