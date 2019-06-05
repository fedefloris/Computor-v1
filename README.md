# Computor-v1 - 42Born2Code
[![Build Status](https://travis-ci.com/fedefloris/Computor-v1.svg?branch=master)](https://travis-ci.com/fedefloris/Computor-v1)

## Challenge
Computor-v1 is a program that solves polynomial equations of degree less than or equal to 3.

For more details look at the [subject](subject.pdf)

## Using the project
```console
git clone https://github.com/fedefloris/Computor_v1.git && cd Computor_v1 && make
```
Linear equations:
```console
$> java -cp class/src ComputorV1 "1 + 2*2*x1"
Reduced form: 4 * X^1 + 1 * X^0 = 0
Degree: 1
The solution is: -0.25
```
```console
$> java -cp class/src ComputorV1 "2 = 0"
Reduced form: 2 * X^0 = 0
Degree: 0
There is no solution because the equation is inconsistent
```
```console
$> java -cp class/src ComputorV1 "10 * x^1 = 10 * x^1"
Reduced form: 0 = 0
Degree: 0
Every value for x is a solution
```
Quadratic equations:
```console
$> java -cp class/src ComputorV1 "x2"
Reduced form: 1 * X^2 = 0
Degree: 2
Discriminant: 0.0
The solution is: 0.0
```
```console
$> java -cp class/src ComputorV1 "x2 = -1"
Reduced form: 1 * X^2 + 1 * X^0 = 0
Degree: 2
Discriminant: -4.0
The two solutions are:
0.0 - 1.0i
0.0 + 1.0i
```
```console
$> java -cp class/src ComputorV1 "2*x2 + 5*x - 3 = 0"
Reduced form: 2 * X^2 + 5 * X^1 - 3 * X^0 = 0
Degree: 2
Discriminant: 49.0
The two solutions are:
-3.0000000000000004
0.5000000000000004
```
Cubic equations:
```console
$> java -cp class/src ComputorV1 "x3 + 2*x2 - 2*x -2 = 0"
Reduced form: 1 * X^3 + 2 * X^2 - 2 * X^1 - 2 * X^0 = 0
Degree: 3
The solutions are:
1.170086486626034
-2.4811943040920155
-0.6888921825340182
```
```console
$> java -cp class/src ComputorV1 "x3 + 6*x2 + 12*x + 8 = 0"
Reduced form: 1 * X^3 + 6 * X^2 + 12 * X^1 + 8 * X^0 = 0
Degree: 3
The solution is: -2.0
```
```console
$> java -cp class/src ComputorV1 "10*x3 + 2*x2 + 4*x + 7 = 0"
Reduced form: 10 * X^3 + 2 * X^2 + 4 * X^1 + 7 * X^0 = 0
Degree: 3
The solutions are:
-0.7979955845772457
0.2989977922886229 + 0.8875799436083823i
0.2989977922886229 - 0.8875799436083823i
```
## Running the tests

```console
make tests
```

## License
This project is licensed under the MIT License - see the [LICENSE.md](LICENSE) file for details
