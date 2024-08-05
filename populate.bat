@echo off
echo Creating Groups...
curl -X POST "http://localhost:8080/api/groups" -H "Content-Type: application/json" -d "{\"name\": \"Group A\"}"
curl -X POST "http://localhost:8080/api/groups" -H "Content-Type: application/json" -d "{\"name\": \"Group B\"}"
curl -X POST "http://localhost:8080/api/groups" -H "Content-Type: application/json" -d "{\"name\": \"Group C\"}"

echo Creating Courses...
curl -X POST "http://localhost:8080/api/courses" -H "Content-Type: application/json" -d "{\"name\": \"Course 1\", \"type\": \"Main\"}"
curl -X POST "http://localhost:8080/api/courses" -H "Content-Type: application/json" -d "{\"name\": \"Course 2\", \"type\": \"Secondary\"}"
curl -X POST "http://localhost:8080/api/courses" -H "Content-Type: application/json" -d "{\"name\": \"Course 3\", \"type\": \"Main\"}"

echo Creating Students...
curl -X POST "http://localhost:8080/api/students" -H "Content-Type: application/json" -d "{\"name\": \"Ivan Ivanov\", \"age\": 20, \"group\": {\"id\": 1}, \"courses\": [{\"id\": 1}, {\"id\": 2}]}"
curl -X POST "http://localhost:8080/api/students" -H "Content-Type: application/json" -d "{\"name\": \"Martin Paraskevov\", \"age\": 22, \"group\": {\"id\": 1}, \"courses\": [{\"id\": 1}]}"
curl -X POST "http://localhost:8080/api/students" -H "Content-Type: application/json" -d "{\"name\": \"Georgi Ivanov\", \"age\": 19, \"group\": {\"id\": 2}, \"courses\": [{\"id\": 2}, {\"id\": 3}]}"
curl -X POST "http://localhost:8080/api/students" -H "Content-Type: application/json" -d "{\"name\": \"Teodor Todorov\", \"age\": 21, \"group\": {\"id\": 2}, \"courses\": [{\"id\": 3}]}"
curl -X POST "http://localhost:8080/api/students" -H "Content-Type: application/json" -d "{\"name\": \"Todor Ivanov\", \"age\": 23, \"group\": {\"id\": 3}, \"courses\": [{\"id\": 1}, {\"id\": 3}]}"
curl -X POST "http://localhost:8080/api/students" -H "Content-Type: application/json" -d "{\"name\": \"Petur Petrov\", \"age\": 24, \"group\": {\"id\": 3}, \"courses\": [{\"id\": 2}]}"
curl -X POST "http://localhost:8080/api/students" -H "Content-Type: application/json" -d "{\"name\": \"Vulcho Ivanov\", \"age\": 20, \"group\": {\"id\": 1}, \"courses\": [{\"id\": 1}, {\"id\": 3}]}"
curl -X POST "http://localhost:8080/api/students" -H "Content-Type: application/json" -d "{\"name\": \"Genadi Ivanov\", \"age\": 25, \"group\": {\"id\": 2}, \"courses\": [{\"id\": 2}, {\"id\": 3}]}"
curl -X POST "http://localhost:8080/api/students" -H "Content-Type: application/json" -d "{\"name\": \"Daniel Branimirov\", \"age\": 22, \"group\": {\"id\": 3}, \"courses\": [{\"id\": 1}, {\"id\": 2}]}"
curl -X POST "http://localhost:8080/api/students" -H "Content-Type: application/json" -d "{\"name\": \"Todor Grishov\", \"age\": 20, \"group\": {\"id\": 1}, \"courses\": [{\"id\": 3}]}"

echo Creating Teachers...
curl -X POST "http://localhost:8080/api/teachers" -H "Content-Type: application/json" -d "{\"name\": \"Prof. Ivan Stanchev\", \"age\": 45, \"courses\": [{\"id\": 1}, {\"id\": 3}], \"groups\": [{\"id\": 1}, {\"id\": 2}]}"
curl -X POST "http://localhost:8080/api/teachers" -H "Content-Type: application/json" -d "{\"name\": \"Dr. Preslav Preslavov\", \"age\": 40, \"courses\": [{\"id\": 2}], \"groups\": [{\"id\": 1}]}"
curl -X POST "http://localhost:8080/api/teachers" -H "Content-Type: application/json" -d "{\"name\": \"Dr. Goth Smith\", \"age\": 42, \"courses\": [{\"id\": 1}], \"groups\": [{\"id\": 2}, {\"id\": 3}]}"
curl -X POST "http://localhost:8080/api/teachers" -H "Content-Type: application/json" -d "{\"name\": \"Prof. Donald Knuth\", \"age\": 50, \"courses\": [{\"id\": 3}], \"groups\": [{\"id\": 2}]}"
curl -X POST "http://localhost:8080/api/teachers" -H "Content-Type: application/json" -d "{\"name\": \"Dr. Substitute Liskov\", \"age\": 38, \"courses\": [{\"id\": 1}, {\"id\": 2}], \"groups\": [{\"id\": 3}]}"

echo Done.
