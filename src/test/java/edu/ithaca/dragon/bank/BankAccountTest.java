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

        //these tests are pationed into two cases. However I think the partion should be by the entry before
        //the @ sign and for the domain name after. Im not sure about the border cases range in this context.


        //added tests for false
        //assertFalse( BankAccount.isEmailValid("abc-@mail.com"));
        assertTrue( BankAccount.isEmailValid("abc..def@mail.com"));
        assertTrue( BankAccount.isEmailValid("abc.def@mail.c"));
        assertFalse( BankAccount.isEmailValid("abc.def@mail"));


        //these tests are

        //added tests for true
        assertTrue(BankAccount.isEmailValid( "abc.def@mail.com"));
        assertTrue(BankAccount.isEmailValid( "abc.def@mail.cc"));
        assertTrue(BankAccount.isEmailValid( "abc-d@mail.com"));
        assertTrue(BankAccount.isEmailValid( "abc.def@mail-archive.com"));


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