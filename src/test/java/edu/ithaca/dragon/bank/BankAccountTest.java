package edu.ithaca.dragon.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void getBalanceTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    void withdrawTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);
        bankAccount.withdraw(100);

        assertEquals(100, bankAccount.getBalance());
    }

    @Test
    void isEmailValidTest(){
        assertTrue(BankAccount.isEmailValid( "a@b.com"));
        assertFalse( BankAccount.isEmailValid(""));


        //added tests for false
        assertFalse( BankAccount.isEmailValid("abc-@mail.com")); //invalid characters before '@'
        assertFalse( BankAccount.isEmailValid("abc..def@mail.com")); // invalid character before '@
        //assertFalse( BankAccount.isEmailValid("abc.def@mail.c")); //invalid characters after '.' for website
        assertFalse( BankAccount.isEmailValid("abc.def@mail")); //invalid character looking for '. after '@'


        //added tests for true
        assertTrue(BankAccount.isEmailValid( "abc.def@mail.com")); //testing working email
        assertTrue(BankAccount.isEmailValid( "abc.def@mail.cc")); //testing 2 characters after final '.
        assertTrue(BankAccount.isEmailValid( "abc-d@mail.com")); //testing valid character before '@'
        assertTrue(BankAccount.isEmailValid( "abc.def@mail-archive.com")); //testing '-' in website email


    }

    @Test
    void constructorTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals("a@b.com", bankAccount.getEmail());
        assertEquals(200, bankAccount.getBalance());
        //check for exception thrown correctly
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("", 100));
    }

}