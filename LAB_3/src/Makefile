all: compile exe1 exe2 test1 test2 test3 test4 test5 clean doc

compile:
	@echo "#-----------------------"
	@echo "Compiling . . ."
	@echo "#-----------------------"
	@echo ""
	javac pr3/traffic/itvs/*.java pr3/traffic/vehicles/*.java pr3/traffic/drivers/*.java pr3/traffic/fines/*.java pr3/traffic/tests/*.java pr3/traffic/license/*.java
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
	javadoc -d ../doc -author pr3/traffic/drivers/*.java pr3/traffic/fines/*.java pr3/traffic/license/*.java pr3/traffic/tests/*.java pr3/traffic/vehicles/*.java pr3/traffic/itvs/*.java
	@echo "\n"
