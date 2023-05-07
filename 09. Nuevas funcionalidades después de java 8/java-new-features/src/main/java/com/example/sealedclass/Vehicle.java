package com.example.sealedclass;

/*
Jerarquía herencia sellada, solo las clases permitidas pueden heredar
 */
public sealed class Vehicle permits Car, MotorCycle{
}
