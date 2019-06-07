package nz.ac.ara.dos0311.Assignment.Part1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Point;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JUnitTestForPlayer {
//	This is static because they only run once.
	static void setup() {
		System.out.println("@BeforeAll - Execute once before all test methods in this class");
	}
	
	@BeforeEach
	void init() {
		System.out.println("@BeforeEach - Executed before each test method in this class");
	}
	
	@AfterEach
	void tearDown() {
		System.out.println("@AfterEach - Executed after each test method in this class");
	}
	
	@AfterAll
	static void done() {
		System.out.println("@AfterAll - Execute once after all test methods in this class");
	}

//	Feature 5 Test
	@Test
	void test01() throws Exception{
		try {
			System.out.println("---------- TEST1 Whether we spawn player on right spot, on Diamond Blue --------------");

//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
//			initialize eyeball at starting point first, DB (Diamond Blue)
			Player eyeball = new Player(5,2,board);
			final String EXPECTED = "D|B";
			final String ERROR_MSG = "It should be at Diamond Blue, Row : 5 and Col : 2";
			
//			Act
//			print the label of it's position which should be DB (Diamond Blue)
			final String ACTUAL = eyeball.getCurrPosition();	
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
		   catch (IllegalArgumentException e) {
		     System.out.println(e.getMessage());
		   }
	}
//	Movement test, include Feature 10, 11, 12, 13, 15, 16
	@Test
	void test02() throws Exception{
		try {
			System.out.println("---------- TEST2 Whether we moved player from DB to DR --------------");

//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
//			initialize eyeball at starting point first, DB (Diamond Blue)
			Player eyeball = new Player(5,2,board);
//			change to location of eyeball to row4, col2
			eyeball.setPlayer(4, 2);
			final String EXPECTED = "D|R";
			final String ERROR_MSG = "It should be at Diamond Red, Row : 4 and Col : 2";
			
//			Act
//			print the label of it's position which should be DR (Diamond Red)
			final String ACTUAL = eyeball.getCurrPosition();	
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
		   catch (IllegalArgumentException e) {
		     System.out.println(e.getMessage());
		   }
	}
	
//	Facing UP
	@Test
	void test03() throws Exception{
		try {
			System.out.println("---------- TEST3 Whether destination block is eligible to go ----------");
			System.out.println("---------- Firstly, test one behind the character ----------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
//			initialize eyeball at starting point first, DB (Diamond Blue)
			Player eyeball = new Player(4,2,board);
			final Boolean EXPECTED = false;
			final String ERROR_MSG = "You cannot go backward at any time";
			
//			Act
//			Block at row6, col2 is actually behind character, so cannot go.
			final Boolean ACTUAL = eyeball.checkDestinationBlock(5, 2);	
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
		   catch (IllegalArgumentException e) {
		     System.out.println(e.getMessage());
		   }
	}
	
	@Test
	void test04() throws Exception{
		try {
			System.out.println("---------- TEST4 Whether destination block is eligible to go --------------");
			System.out.println("---------- Secondly, test one thats not on characters way ----------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
//			initialize eyeball at starting point first, DB (Diamond Blue)
			Player eyeball = new Player(5,2,board);
			final Boolean EXPECTED = false;
			final String ERROR_MSG = "You can only go straight";
			
//			Act
//			Block at row5, col3 is not on the way that character is facing
			final Boolean ACTUAL = eyeball.checkDestinationBlock(5, 3);	
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
		   catch (IllegalArgumentException e) {
		     System.out.println(e.getMessage());
		   }
	}
	
	@Test
	void test05() throws Exception{
		try {
			System.out.println("---------- TEST5 Whether destination block is eligible to go --------------");
			System.out.println("---------- Thirdly, test one thats on characters way and same color ----------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
//			initialize eyeball at starting point first, DB (Diamond Blue)
			Player eyeball = new Player(5,2,board);
			final Boolean EXPECTED = true;
			final String ERROR_MSG = "You can only go to same color or same shape";
			
//			Act
//			Block at row3, col2 is Flower Blue which is same colour
			final Boolean ACTUAL = eyeball.checkDestinationBlock(3, 2);	
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
		   catch (IllegalArgumentException e) {
		     System.out.println(e.getMessage());
		   }
	}
	
	@Test
	void test06() throws Exception{
		try {
			System.out.println("---------- TEST6 Whether destination block is eligible to go --------------");
			System.out.println("---------- Fourthly, test one thats on characters way and same shape ----------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
//			initialize eyeball at starting point first, DB (Diamond Blue)
			Player eyeball = new Player(5,2,board);
			final Boolean EXPECTED = true;
			final String ERROR_MSG = "You can only go to same color or same shape";
			
//			Act
//			Block at row4, col2 is Diamond Red which is same shape
			final Boolean ACTUAL = eyeball.checkDestinationBlock(4, 2);		
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
		   catch (IllegalArgumentException e) {
		     System.out.println(e.getMessage());
		   }
	}
	
	@Test
	void test07() throws Exception{
		try {
			System.out.println("---------- TEST7 Whether destination block is eligible to go --------------");
			System.out.println("---------- Fifthly, test one thats on characters way but neither same color nor shape ----------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
//			initialize eyeball at starting point first, DB (Diamond Blue)
			Player eyeball = new Player(5,2,board);
			final Boolean EXPECTED = false;
			final String ERROR_MSG = "You can only go to same color or same shape";
			
//			Act
//			Block at row2, col2 is Star Red which is neither same color nor shape
			final Boolean ACTUAL = eyeball.checkDestinationBlock(2, 2);		
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
		   catch (IllegalArgumentException e) {
		     System.out.println(e.getMessage());
		   }
	}
	
	@Test
	void test08() throws Exception{
		try {
			System.out.println("---------- TEST8 Whether destination block is eligible to go --------------");
			System.out.println("---------- Checking for left with same shape ----------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
//			initialize eyeball at starting point first, FB (Flower Blue)
			Player eyeball = new Player(3,2,board);
			final Boolean EXPECTED = true;
			final String ERROR_MSG = "You can only go to same color or same shape";
			
//			Act
//			Block at row3, col1 is Flower Red which is same sahpe
			final Boolean ACTUAL = eyeball.checkDestinationBlock(3, 1);		
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
		   catch (IllegalArgumentException e) {
		     System.out.println(e.getMessage());
		   }
	}
	
	@Test
	void test09() throws Exception{
		try {
			System.out.println("---------- TEST9 Whether destination block is eligible to go --------------");
			System.out.println("---------- Checking for right with same shape ----------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
//			initialize eyeball at starting point first, FB (Flower Blue)
			Player eyeball = new Player(3,2,board);
			final Boolean EXPECTED = true;
			final String ERROR_MSG = "You can only go to same color or same shape";
			
//			Act
//			Block at row3, col4 is Flower Green which is shape
			final Boolean ACTUAL = eyeball.checkDestinationBlock(3, 4);		
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
		   catch (IllegalArgumentException e) {
		     System.out.println(e.getMessage());
		   }
	}
	
	@Test
	void test10() throws Exception{
		try {
			System.out.println("---------- TEST10 Whether destination block is eligible to go --------------");
			System.out.println("---------- Checking for left with same colour ----------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
//			initialize eyeball at starting point first, DY (Diamond Yellow)
			Player eyeball = new Player(1,3,board);
			final Boolean EXPECTED = true;
			final String ERROR_MSG = "You can only go to same color or same shape";
			
//			Act
//			Block at row1, col2 is Flower Yellow which is same colour
			final Boolean ACTUAL = eyeball.checkDestinationBlock(1, 2);		
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
		   catch (IllegalArgumentException e) {
		     System.out.println(e.getMessage());
		   }
	}
	
	@Test
	void test11() throws Exception{
		try {
			System.out.println("---------- TEST11 Whether destination block is eligible to go --------------");
			System.out.println("---------- Checking for right with same colour ----------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
//			initialize eyeball at starting point first, SB (Star Blue)
			Player eyeball = new Player(4,1,board);
			final Boolean EXPECTED = true;
			final String ERROR_MSG = "You can only go to same color or same shape";
			
//			Act
//			Block at row4, col4 is Diamond Blue which is same colour
			final Boolean ACTUAL = eyeball.checkDestinationBlock(4, 4);		
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
		   catch (IllegalArgumentException e) {
		     System.out.println(e.getMessage());
		   }
	}
	
	@Test
	void test12() throws Exception{
		try {
			System.out.println("---------- TEST12 Whether destination block is eligible to go --------------");
			System.out.println("---------- Checking for left neither colour nor shape ----------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
//			initialize eyeball at starting point first, DY (Diamond Yellow)
			Player eyeball = new Player(1,3,board);
			final Boolean EXPECTED = false;
			final String ERROR_MSG = "You can only go to same color or same shape";
			
//			Act
//			Block at row1, col1 is Cross Blue which neither
			final Boolean ACTUAL = eyeball.checkDestinationBlock(1, 1);		
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
		   catch (IllegalArgumentException e) {
		     System.out.println(e.getMessage());
		   }
	}
	
	@Test
	void test13() throws Exception{
		try {
			System.out.println("---------- TEST13 Whether destination block is eligible to go --------------");
			System.out.println("---------- Checking for right neither colour nor shape ----------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
//			initialize eyeball at starting point first, SB (Star Blue)
			Player eyeball = new Player(4,1,board);
			final Boolean EXPECTED = false;
			final String ERROR_MSG = "You can only go to same color or same shape";
			
//			Act
//			Block at row4, col2 is Diamond Red which is neither
			final Boolean ACTUAL = eyeball.checkDestinationBlock(4, 2);		
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
		   catch (IllegalArgumentException e) {
		     System.out.println(e.getMessage());
		   }
	}
//	Facing Left
	@Test
	void test14() throws Exception{
		try {
			System.out.println("---------- TEST14 Whether destination block is eligible to go ----------");
			System.out.println("---------- Firstly, test one behind the character ----------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
//			initialize eyeball at starting point first, DB (Diamond Blue)
			Player eyeball = new Player(4,2,board);
			eyeball.direction = "l";
			final Boolean EXPECTED = false;
			final String ERROR_MSG = "You cannot go backward at any time";
			
//			Act
//			Block at row4, col3 is actually behind character, so cannot go.
			final Boolean ACTUAL = eyeball.checkDestinationBlock(4, 3);	
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
		   catch (IllegalArgumentException e) {
		     System.out.println(e.getMessage());
		   }
	}
	
	@Test
	void test15() throws Exception{
		try {
			System.out.println("---------- TEST15 Whether destination block is eligible to go --------------");
			System.out.println("---------- Secondly, test one thats not on characters way ----------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
//			initialize eyeball at starting point first, DB (Diamond Blue)
			Player eyeball = new Player(5,2,board);
			eyeball.direction = "l";
			final Boolean EXPECTED = false;
			final String ERROR_MSG = "You can only go straight, left or right";
			
//			Act
//			Block at row4, col1 is at diagonal
			final Boolean ACTUAL = eyeball.checkDestinationBlock(4, 1);	
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
		   catch (IllegalArgumentException e) {
		     System.out.println(e.getMessage());
		   }
	}
	
	@Test
	void test16() throws Exception{
		try {
			System.out.println("---------- TEST16 Whether destination block is eligible to go --------------");
			System.out.println("---------- Thirdly, test one thats on characters way and same shape ----------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
//			initialize eyeball at starting point first, FB (Flower Blue)
			Player eyeball = new Player(3,2,board);
			eyeball.direction = "l";
			final Boolean EXPECTED = true;
			final String ERROR_MSG = "You can only go to same color or same shape";
			
//			Act
//			Block at row3, col1 is Flower Red which is same shape
			final Boolean ACTUAL = eyeball.checkDestinationBlock(3, 1);	
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
		   catch (IllegalArgumentException e) {
		     System.out.println(e.getMessage());
		   }
	}
	
	@Test
	void test17() throws Exception{
		try {
			System.out.println("---------- TEST17 Whether destination block is eligible to go --------------");
			System.out.println("---------- Fifthly, test one thats on characters way but neither same color nor shape ----------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
//			initialize eyeball at starting point first, DR (Diamond Red)
			Player eyeball = new Player(4,2,board);
			eyeball.direction = "l";
			final Boolean EXPECTED = false;
			final String ERROR_MSG = "You can only go to same color or same shape";
			
//			Act
//			Block at row4, col1 is Star Blue which is neither same color nor shape
			final Boolean ACTUAL = eyeball.checkDestinationBlock(4, 1);		
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
		   catch (IllegalArgumentException e) {
		     System.out.println(e.getMessage());
		   }
	}
	
	@Test
	void test18() throws Exception{
		try {
			System.out.println("---------- TEST18 Whether destination block is eligible to go --------------");
			System.out.println("---------- Checking for left with same shape ----------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
//			initialize eyeball at starting point first, DR (Diamond Red)
			Player eyeball = new Player(4,2,board);
			eyeball.direction = "l";
			final Boolean EXPECTED = true;
			final String ERROR_MSG = "You can only go to same color or same shape";
			
//			Act
//			Block at row5, col2 is Diamond Blue which is same sahpe
			final Boolean ACTUAL = eyeball.checkDestinationBlock(5, 2);		
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
		   catch (IllegalArgumentException e) {
		     System.out.println(e.getMessage());
		   }
	}
	
	@Test
	void test19() throws Exception{
		try {
			System.out.println("---------- TEST19 Whether destination block is eligible to go --------------");
			System.out.println("---------- Checking for right with same shape ----------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
//			initialize eyeball at starting point first, FB (Flower Blue)
			Player eyeball = new Player(3,2,board);
			eyeball.direction = "l";
			final Boolean EXPECTED = true;
			final String ERROR_MSG = "You can only go to same color or same shape";
			
//			Act
//			Block at row1, col2 is Flower Yellow which is shape
			final Boolean ACTUAL = eyeball.checkDestinationBlock(1, 2);		
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
		   catch (IllegalArgumentException e) {
		     System.out.println(e.getMessage());
		   }
	}
	
	@Test
	void test20() throws Exception{
		try {
			System.out.println("---------- TEST20 Whether destination block is eligible to go --------------");
			System.out.println("---------- Checking for left with same colour ----------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
//			initialize eyeball at starting point first, CG (Cross Green)
			Player eyeball = new Player(1,4,board);
			eyeball.direction = "l";
			final Boolean EXPECTED = true;
			final String ERROR_MSG = "You can only go to same color or same shape";
			
//			Act
//			Block at row3, col4 is Flower Green which is same colour
			final Boolean ACTUAL = eyeball.checkDestinationBlock(3, 4);		
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
		   catch (IllegalArgumentException e) {
		     System.out.println(e.getMessage());
		   }
	}
	
	@Test
	void test21() throws Exception{
		try {
			System.out.println("---------- TEST21 Whether destination block is eligible to go --------------");
			System.out.println("---------- Checking for right with same colour ----------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
//			initialize eyeball at starting point first, SB (Star Blue)
			Player eyeball = new Player(4,1,board);
			eyeball.direction = "l";
			final Boolean EXPECTED = true;
			final String ERROR_MSG = "You can only go to same color or same shape";
			
//			Act
//			Block at row1, col1 is Cross Blue which is same colour
			final Boolean ACTUAL = eyeball.checkDestinationBlock(1, 1);		
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
		   catch (IllegalArgumentException e) {
		     System.out.println(e.getMessage());
		   }
	}
	
	@Test
	void test22() throws Exception{
		try {
			System.out.println("---------- TEST22 Whether destination block is eligible to go --------------");
			System.out.println("---------- Checking for left neither colour nor shape ----------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
//			initialize eyeball at starting point first, DY (Diamond Yellow)
			Player eyeball = new Player(1,3,board);
			eyeball.direction = "l";
			final Boolean EXPECTED = false;
			final String ERROR_MSG = "You can only go to same color or same shape";
			
//			Act
//			Block at row2, col3 is Star Green which neither
			final Boolean ACTUAL = eyeball.checkDestinationBlock(2, 3);		
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
		   catch (IllegalArgumentException e) {
		     System.out.println(e.getMessage());
		   }
	}
	
	@Test
	void test23() throws Exception{
		try {
			System.out.println("---------- TEST13 Whether destination block is eligible to go --------------");
			System.out.println("---------- Checking for right neither colour nor shape ----------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
//			initialize eyeball at starting point first, SB (Star Blue)
			Player eyeball = new Player(4,1,board);
			eyeball.direction = "l";
			final Boolean EXPECTED = false;
			final String ERROR_MSG = "You can only go to same color or same shape";
			
//			Act
//			Block at row3, col1 is Flower Red which is neither
			final Boolean ACTUAL = eyeball.checkDestinationBlock(3, 1);		
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
		   catch (IllegalArgumentException e) {
		     System.out.println(e.getMessage());
		   }
	}
//	Facing Down
	@Test
	void test24() throws Exception{
		try {
			System.out.println("---------- TEST24 Whether destination block is eligible to go ----------");
			System.out.println("---------- Firstly, test one behind the character ----------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
//			initialize eyeball at starting point first, DB (Diamond Blue)
			Player eyeball = new Player(5,2,board);
			eyeball.direction = "d";
			final Boolean EXPECTED = false;
			final String ERROR_MSG = "You cannot go backward at any time";
			
//			Act
//			Block at row3, col2 is actually behind character, so cannot go.
			final Boolean ACTUAL = eyeball.checkDestinationBlock(3, 2);	
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
		   catch (IllegalArgumentException e) {
		     System.out.println(e.getMessage());
		   }
	}
	
	@Test
	void test25() throws Exception{
		try {
			System.out.println("---------- TEST25 Whether destination block is eligible to go --------------");
			System.out.println("---------- Secondly, test one thats not on characters way ----------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
//			initialize eyeball at starting point first, FB (Flower Blue)
			Player eyeball = new Player(3,2,board);
			eyeball.direction = "d";
			final Boolean EXPECTED = false;
			final String ERROR_MSG = "You can only go straight, left or right";
			
//			Act
//			Block at row4, col1 is at diagonal
			final Boolean ACTUAL = eyeball.checkDestinationBlock(4, 1);	
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
		   catch (IllegalArgumentException e) {
		     System.out.println(e.getMessage());
		   }
	}
	
	@Test
	void test26() throws Exception{
		try {
			System.out.println("---------- TEST26 Whether destination block is eligible to go --------------");
			System.out.println("---------- Thirdly, test one thats on characters way and same shape ----------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
//			initialize eyeball at starting point first, FB (Flower Blue)
			Player eyeball = new Player(3,2,board);
			eyeball.direction = "d";
			final Boolean EXPECTED = true;
			final String ERROR_MSG = "You can only go to same color or same shape";
			
//			Act
//			Block at row5, col2 is Diamond Blue which is same colour
			final Boolean ACTUAL = eyeball.checkDestinationBlock(5, 2);	
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
		   catch (IllegalArgumentException e) {
		     System.out.println(e.getMessage());
		   }
	}
	
	@Test
	void test27() throws Exception{
		try {
			System.out.println("---------- TEST27 Whether destination block is eligible to go --------------");
			System.out.println("---------- Fifthly, test one thats on characters way but neither same color nor shape ----------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
//			initialize eyeball at starting point first, DR (Diamond Red)
			Player eyeball = new Player(4,2,board);
			eyeball.direction = "d";
			final Boolean EXPECTED = false;
			final String ERROR_MSG = "You can only go to same color or same shape";
			
//			Act
//			Block at row4, col1 is Star Blue which is neither same color nor shape
			final Boolean ACTUAL = eyeball.checkDestinationBlock(4, 1);		
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
		   catch (IllegalArgumentException e) {
		     System.out.println(e.getMessage());
		   }
	}
	
	@Test
	void test28() throws Exception{
		try {
			System.out.println("---------- TEST28 Whether destination block is eligible to go --------------");
			System.out.println("---------- Checking for left with same shape ----------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
//			initialize eyeball at starting point first, DR (Diamond Red)
			Player eyeball = new Player(4,2,board);
			eyeball.direction = "d";
			final Boolean EXPECTED = true;
			final String ERROR_MSG = "You can only go to same color or same shape";
			
//			Act
//			Block at row4, col4 is Diamond Blue which is same sahpe
			final Boolean ACTUAL = eyeball.checkDestinationBlock(4, 4);		
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
		   catch (IllegalArgumentException e) {
		     System.out.println(e.getMessage());
		   }
	}
	
	@Test
	void test29() throws Exception{
		try {
			System.out.println("---------- TEST29 Whether destination block is eligible to go --------------");
			System.out.println("---------- Checking for right with same shape ----------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
//			initialize eyeball at starting point first, FB (Flower Blue)
			Player eyeball = new Player(3,2,board);
			eyeball.direction = "d";
			final Boolean EXPECTED = true;
			final String ERROR_MSG = "You can only go to same color or same shape";
			
//			Act
//			Block at row3, col1 is Flower Red which is shape
			final Boolean ACTUAL = eyeball.checkDestinationBlock(3, 1);		
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
		   catch (IllegalArgumentException e) {
		     System.out.println(e.getMessage());
		   }
	}
	
	@Test
	void test30() throws Exception{
		try {
			System.out.println("---------- TEST30 Whether destination block is eligible to go --------------");
			System.out.println("---------- Checking for left with same colour ----------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
//			initialize eyeball at starting point first, FY (Flower Yellow)
			Player eyeball = new Player(1,2,board);
			eyeball.direction = "d";
			final Boolean EXPECTED = true;
			final String ERROR_MSG = "You can only go to same color or same shape";
			
//			Act
//			Block at row1, col3 is Diamond Yellow which is same colour
			final Boolean ACTUAL = eyeball.checkDestinationBlock(1, 3);		
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
		   catch (IllegalArgumentException e) {
		     System.out.println(e.getMessage());
		   }
	}
	
	@Test
	void test31() throws Exception{
		try {
			System.out.println("---------- TEST31 Whether destination block is eligible to go --------------");
			System.out.println("---------- Checking for right with same colour ----------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
//			initialize eyeball at starting point first, SG (Star Green)
			Player eyeball = new Player(2,3,board);
			eyeball.direction = "d";
			final Boolean EXPECTED = true;
			final String ERROR_MSG = "You can only go to same color or same shape";
			
//			Act
//			Block at row2, col1 is Flower Green which is same colour
			final Boolean ACTUAL = eyeball.checkDestinationBlock(2, 1);		
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
		   catch (IllegalArgumentException e) {
		     System.out.println(e.getMessage());
		   }
	}
	
	@Test
	void test32() throws Exception{
		try {
			System.out.println("---------- TEST32 Whether destination block is eligible to go --------------");
			System.out.println("---------- Checking for left neither colour nor shape ----------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
//			initialize eyeball at starting point first, DY (Diamond Yellow)
			Player eyeball = new Player(1,3,board);
			eyeball.direction = "d";
			final Boolean EXPECTED = false;
			final String ERROR_MSG = "You can only go to same color or same shape";
			
//			Act
//			Block at row1, col4 is Star Green which neither
			final Boolean ACTUAL = eyeball.checkDestinationBlock(1, 4);		
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
		   catch (IllegalArgumentException e) {
		     System.out.println(e.getMessage());
		   }
	}
	
	@Test
	void test33() throws Exception{
		try {
			System.out.println("---------- TEST33 Whether destination block is eligible to go --------------");
			System.out.println("---------- Checking for right neither colour nor shape ----------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
//			initialize eyeball at starting point first, CG (Cross Green)
			Player eyeball = new Player(1,4,board);
			eyeball.direction = "d";
			final Boolean EXPECTED = false;
			final String ERROR_MSG = "You can only go to same color or same shape";
			
//			Act
//			Block at row1, col3 is Diamond Yellow which is neither
			final Boolean ACTUAL = eyeball.checkDestinationBlock(1, 3);		
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
		   catch (IllegalArgumentException e) {
		     System.out.println(e.getMessage());
		   }
	}
//	Facing Right
	@Test
	void test34() throws Exception{
		try {
			System.out.println("---------- TEST34 Whether destination block is eligible to go ----------");
			System.out.println("---------- Firstly, test one behind the character ----------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
//			initialize eyeball at starting point first, DR (Diamond Red)
			Player eyeball = new Player(4,2,board);
			eyeball.direction = "r";
			final Boolean EXPECTED = false;
			final String ERROR_MSG = "You cannot go backward at any time";
			
//			Act
//			Block at row4, col1 is actually behind character, so cannot go.
			final Boolean ACTUAL = eyeball.checkDestinationBlock(4, 1);	
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
		   catch (IllegalArgumentException e) {
		     System.out.println(e.getMessage());
		   }
	}
	
	@Test
	void test35() throws Exception{
		try {
			System.out.println("---------- TEST35 Whether destination block is eligible to go --------------");
			System.out.println("---------- Secondly, test one thats not on characters way ----------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
//			initialize eyeball at starting point first, FB (Flower Blue)
			Player eyeball = new Player(3,2,board);
			eyeball.direction = "r";
			final Boolean EXPECTED = false;
			final String ERROR_MSG = "You can only go straight, left or right";
			
//			Act
//			Block at row4, col3 is at diagonal
			final Boolean ACTUAL = eyeball.checkDestinationBlock(4, 3);	
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
		   catch (IllegalArgumentException e) {
		     System.out.println(e.getMessage());
		   }
	}
	
	@Test
	void test36() throws Exception{
		try {
			System.out.println("---------- TEST36 Whether destination block is eligible to go --------------");
			System.out.println("---------- Thirdly, test one thats on characters way and same shape ----------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
//			initialize eyeball at starting point first, FB (Flower Blue)
			Player eyeball = new Player(3,2,board);
			eyeball.direction = "r";
			final Boolean EXPECTED = true;
			final String ERROR_MSG = "You can only go to same color or same shape";
			
//			Act
//			Block at row3, col4 is Flower Green which is same colour
			final Boolean ACTUAL = eyeball.checkDestinationBlock(3, 4);	
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
		   catch (IllegalArgumentException e) {
		     System.out.println(e.getMessage());
		   }
	}
	
	@Test
	void test37() throws Exception{
		try {
			System.out.println("---------- TEST37 Whether destination block is eligible to go --------------");
			System.out.println("---------- Fifthly, test one thats on characters way but neither same color nor shape ----------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
//			initialize eyeball at starting point first, DR (Diamond Red)
			Player eyeball = new Player(4,2,board);
			eyeball.direction = "r";
			final Boolean EXPECTED = false;
			final String ERROR_MSG = "You can only go to same color or same shape";
			
//			Act
//			Block at row4, col3 is Flower Blue which is neither same color nor shape
			final Boolean ACTUAL = eyeball.checkDestinationBlock(4, 3);		
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
		   catch (IllegalArgumentException e) {
		     System.out.println(e.getMessage());
		   }
	}
	
	@Test
	void test38() throws Exception{
		try {
			System.out.println("---------- TEST38 Whether destination block is eligible to go --------------");
			System.out.println("---------- Checking for left with same shape ----------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
//			initialize eyeball at starting point first, DB (Diamond Blue)
			Player eyeball = new Player(4,4,board);
			eyeball.direction = "r";
			final Boolean EXPECTED = true;
			final String ERROR_MSG = "You can only go to same shape";
			
//			Act
//			Block at row2, col4 is Diamond Yellow which is same sahpe
			final Boolean ACTUAL = eyeball.checkDestinationBlock(2, 4);		
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
		   catch (IllegalArgumentException e) {
		     System.out.println(e.getMessage());
		   }
	}
	
	@Test
	void test39() throws Exception{
		try {
			System.out.println("---------- TEST39 Whether destination block is eligible to go --------------");
			System.out.println("---------- Checking for right with same shape ----------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
//			initialize eyeball at starting point first, SG (Star Green)
			Player eyeball = new Player(2,3,board);
			eyeball.direction = "r";
			final Boolean EXPECTED = true;
			final String ERROR_MSG = "You can only go to same color or same shape";
			
//			Act
//			Block at row3, col3 is Star Red which is shape
			final Boolean ACTUAL = eyeball.checkDestinationBlock(3, 3);		
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
		   catch (IllegalArgumentException e) {
		     System.out.println(e.getMessage());
		   }
	}
	
	@Test
	void test40() throws Exception{
		try {
			System.out.println("---------- TEST40 Whether destination block is eligible to go --------------");
			System.out.println("---------- Checking for left with same colour ----------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
//			initialize eyeball at starting point first, FG (Flower Green)
			Player eyeball = new Player(3,4,board);
			eyeball.direction = "r";
			final Boolean EXPECTED = true;
			final String ERROR_MSG = "You can only go to same color or same shape";
			
//			Act
//			Block at row1, col4 is Cross Green which is same colour
			final Boolean ACTUAL = eyeball.checkDestinationBlock(1, 4);		
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
		   catch (IllegalArgumentException e) {
		     System.out.println(e.getMessage());
		   }
	}
	
	@Test
	void test41() throws Exception{
		try {
			System.out.println("---------- TEST41 Whether destination block is eligible to go --------------");
			System.out.println("---------- Checking for right with same colour ----------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
//			initialize eyeball at starting point first, CB (Cross Blue)
			Player eyeball = new Player(1,1,board);
			eyeball.direction = "r";
			final Boolean EXPECTED = true;
			final String ERROR_MSG = "You can only go to same color or same shape";
			
//			Act
//			Block at row4, col1 is Star Blue which is same colour
			final Boolean ACTUAL = eyeball.checkDestinationBlock(4, 1);		
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
		   catch (IllegalArgumentException e) {
		     System.out.println(e.getMessage());
		   }
	}
	
	@Test
	void test42() throws Exception{
		try {
			System.out.println("---------- TEST42 Whether destination block is eligible to go --------------");
			System.out.println("---------- Checking for left neither colour nor shape ----------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
//			initialize eyeball at starting point first, DY (Diamond Yellow)
			Player eyeball = new Player(1,3,board);
			eyeball.direction = "r";
			final Boolean EXPECTED = false;
			final String ERROR_MSG = "You can only go to same color or same shape";
			
//			Act
//			Block at row2, col3 is Star Green which neither
			final Boolean ACTUAL = eyeball.checkDestinationBlock(2, 3);		
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
		   catch (IllegalArgumentException e) {
		     System.out.println(e.getMessage());
		   }
	}
	
	@Test
	void test43() throws Exception{
		try {
			System.out.println("---------- TEST43 Whether destination block is eligible to go --------------");
			System.out.println("---------- Checking for right neither colour nor shape ----------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
			Player eyeball = new Player(1,3,board);
			final Boolean EXPECTED = false;
			final String ERROR_MSG = "You can only go to same color or same shape";
			
//			Act
//			Block at row1, col4 is Cross Green which is neither
			final Boolean ACTUAL = eyeball.checkDestinationBlock(1, 4);		
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
	   }
	   catch (IllegalArgumentException e) {
		   System.out.println(e.getMessage());
	   }
	}
	
	@Test
	void test44() throws Exception{
		try {
			System.out.println("---------- TEST44 Whether destination block is eligible to go --------------");
			System.out.println("---------- Checking for right neither colour nor shape ----------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
			board.setGoal(0, 3);
			
			final Point EXPECTED = new Point(0, 3);
			final String ERROR_MSG = "Goal must be row 0 col 3, Flower Red";
			
//			Act
//			I know its magic number but will be using iterator for later in andorid implementation as there could be
//			more than one goal
			final Point ACTUAL = board.goal[0];		
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
	   catch (IllegalArgumentException e) {
		   System.out.println(e.getMessage());
	   }
	}
	
//	Feature 19 Test
	@Test
	void test45() throws Exception{
		try {
			System.out.println("---------- TEST45 when eyeball goes to left, is it turning left as well ? --------------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
			
//			spawning on Diamond, Yellow facing up
			Player eyeball = new Player(1,3,board);
			
//			move to Flower yellow, which is moving left from Diamond Yellow
			eyeball.moveEyeball(1, 2);
			final String EXPECTED = "l";
			final String ERROR_MSG = "Eh eh, turning left, must be l direction";
			
//			Act
			final String ACTUAL = eyeball.getCurrentDirection();	
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
	   catch (IllegalArgumentException e) {
		   System.out.println(e.getMessage());
	   }
	}
	
//	Feature 20 Test
	@Test
	void test46() throws Exception{
		try {
			System.out.println("---------- TEST46 when eyeball goes to right, is it turning right as well ? --------------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
			
//			spawning on Flower, Blue facing up
			Player eyeball = new Player(4,3,board);
			
//			move to Diamond Blue, which is moving right from Flower Blue
			eyeball.moveEyeball(4, 4);
			final String EXPECTED = "r";
			final String ERROR_MSG = "Eh eh, turning right, must be r direction";
			
//			Act
			final String ACTUAL = eyeball.getCurrentDirection();	
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
	   catch (IllegalArgumentException e) {
		   System.out.println(e.getMessage());
	   }
	}

//	Feature 21 Test
	@Test
	void test47() throws Exception{
		try {
			System.out.println("---------- TEST47 when eyeball gets Goal block, player wins --------------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
			board.setGoal(0, 3);
//			spawning on Flower, Blue facing up
			Player eyeball = new Player(4,3,board);

			final Boolean EXPECTED = true;
			final String ERROR_MSG = "I am at goal, why am I not a winnder";
			
//			Act
//			move to Diamond Blue, which is moving right from Flower Blue
			eyeball.moveEyeball(0, 3);
			final Boolean ACTUAL = eyeball.gameIsOver;	
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
	   catch (IllegalArgumentException e) {
		   System.out.println(e.getMessage());
	   }
	}
	
//	Feature 17 Test
	@Test
	void test48() throws Exception{
		try {
			System.out.println("---------- TEST48 Test the timer --------------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
			board.setGoal(0, 3);
//			spawning on Diamond, Blue facing up
			Player eyeball = new Player(5,2,board);
//			if it was played by human, there will be time taken to choose next movement.
//			instead, testing with machine, let them sleep otherwise machine is too fast to calculate time
			Thread.sleep(10);
			eyeball.moveEyeball(3,2);
			Thread.sleep(10);
			eyeball.moveEyeball(3,4);
			Thread.sleep(10);
			eyeball.moveEyeball(1,4);
			Thread.sleep(10);
			eyeball.moveEyeball(1,1);
			Thread.sleep(10);
			eyeball.moveEyeball(4,1);
			Thread.sleep(10);
			eyeball.moveEyeball(4,3);
			Thread.sleep(10);
			eyeball.moveEyeball(0,3);
			System.out.println(board.calculateTimer());
			final Boolean EXPECTED = true;
			final String ERROR_MSG = "Eh eh, time taken must be bigger than 0 as 0sec means didnt even start";
			
//			Act
			final Boolean ACTUAL = board.calculateTimer() > 0;	
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
	   catch (IllegalArgumentException e) {
		   System.out.println(e.getMessage());
	   }
	}
	
//	Feature 14 Test
	@Test
	void test49() throws Exception{
		try {
			System.out.println("---------- TEST49 Player lost --------------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
			board.setGoal(0, 3);
//			spawning on Flower, Blue facing up
			Player eyeball = new Player(4,3,board);
//			playerFailed method check whether movement is higher than 50
			eyeball.countMovement = 49;
//			two more movement from 49, 51 which is higher than 50
//			this case program will measure game status as failure.
			eyeball.moveEyeball(4, 1);
			eyeball.moveEyeball(1, 1);
			final Boolean EXPECTED = true;
			final String ERROR_MSG = "You moved too much, must be lost";
			
//			Act
			final Boolean ACTUAL = eyeball.playerFailed();	
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
	   catch (IllegalArgumentException e) {
		   System.out.println(e.getMessage());
	   }
	}
	
//	Feature 9 Test
	@Test
	void test50() throws Exception{
		try {
			System.out.println("---------- TEST50 movement count --------------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
			board.setGoal(0, 3);
//			spawning on Flower, Blue facing up
			Player eyeball = new Player(4,3,board);
//			moving two times which will increase 2, 1 each.
			eyeball.moveEyeball(4, 1);
			eyeball.moveEyeball(1, 1);
			final int EXPECTED = 2;
			final String ERROR_MSG = "They moved only twice.";
			
//			Act
			final int ACTUAL = eyeball.getCurrentMoveCount();	
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
	   catch (IllegalArgumentException e) {
		   System.out.println(e.getMessage());
	   }
	}
//	Feature 7&8 Test
	@Test
	void test51() throws Exception{
		try {
			System.out.println("---------- TEST51 create tile with certain colour and shape --------------");
//			Arrange
			Board board = new Board(6);
			Block block = new Block();
//			set tile color to r, red, shape to f, flower
			block.setShape("f");
			block.setColor("r");
//			get those into string and store into array
			board.map[0][3] = block.getBlock();
			
			final String EXPECTED = "F|R";
			final String ERROR_MSG = "Eh eh, I set this block as Flower Red";
			
//			Act
			final String ACTUAL = board.map[0][3];	
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
	   catch (IllegalArgumentException e) {
		   System.out.println(e.getMessage());
	   }
	}
	
//	Feature 6 Test
	@Test
	void test52() throws Exception{
		try {
			System.out.println("---------- TEST52 generate Eyeball --------------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
//			generate eyeball at row 4, col 2 board
			Player eyeball = new Player(4, 2, board);
			final String EXPECTED = "D|R";
			final String ERROR_MSG = "Eh eh, I set eyeball at coordinate (4,2)";
			
//			Act
			final String ACTUAL = eyeball.getCurrPosition();
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
	   catch (IllegalArgumentException e) {
		   System.out.println(e.getMessage());
	   }
	}

//	Feature 4 Test
	@Test
	void test53() throws Exception{
		try {
			System.out.println("---------- TEST53 Reset the game --------------");
//			Arrange
			Board board = new Board(6);
			board.stageOneBoard();
//			generate eyeball at row 5, col 2 board
			Player eyeball = new Player(5, 2, board);
//			using setPlayer method as we just need to put eyeball somewhere else and put them back to starting point
//			by resetting game.
			eyeball.setPlayer(2, 2);
			eyeball.setPlayer(3, 3);
			eyeball.setPlayer(4, 4);
			
			final String EXPECTED = "D|B";
			final String ERROR_MSG = "Eh eh, I set eyeball at coordinate (4,2)";
			
//			Act
//			now player is back to row 4 and col 2, direction is back to up
//			0 movement
			eyeball.resetPlayer();
			final String ACTUAL = eyeball.getCurrPosition();
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
	   catch (IllegalArgumentException e) {
		   System.out.println(e.getMessage());
	   }
	}
	
//	Feature 3 Test
	@Test
	void test54() throws Exception{
		try {
			System.out.println("---------- TEST54 Choose the maze level --------------");
//			Arrange
			int size = 6;
			Board board = new Board(size);
//			this can be changed for different level but we are testing with stage one.
			board.stageOneBoard();
			
			String EXPECTED = "";
			final String ERROR_MSG = "It must be a stage one board";
			
			for (int row = 0; row < size; row++) {
	            for (int col = 0; col < size; col++) {
	                EXPECTED += " " + board.map[row][col];
	            }
	            EXPECTED += " ";
	        }
//			Act
			final String ACTUAL = " X|X X|X X|X F|R X|X X|X  X|X C|B F|Y D|Y C|G X|X  X|X F|G S|R S|G D|Y X|X  X|X F|R F|B S|R F|G X|X  X|X S|B D|R F|B D|B X|X  X|X X|X D|B X|X X|X X|X ";
		
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
	   catch (IllegalArgumentException e) {
		   System.out.println(e.getMessage());
	   }
	}

//	Feature 2 Test
	@Test
	void test55() throws Exception{
		try {
			System.out.println("---------- TEST55 Go back one movement --------------");
//			Arrange
			int size = 6;
			Board board = new Board(size);
			board.stageOneBoard();
//			we are going to move from Diamond Blue to Flower Blue then bring it back to start point.
			Player eyeball = new Player(5,2,board);
			eyeball.moveEyeball(3, 2);
			
			final String EXPECTED = "D|B";
			final String ERROR_MSG = "Previous coordinate was 5,2";
			

//			Act
//			going back once
			eyeball.goBackOneMove();
			final String ACTUAL = eyeball.getCurrPosition();
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
	   catch (IllegalArgumentException e) {
		   System.out.println(e.getMessage());
	   }
	}

//	Feature 1 Test
	@Test
	void test56() throws Exception{
		try {
			System.out.println("---------- TEST56 Turning sound off --------------");
//			Arrange
//			when board is initialized, default setup for music is true, playing
			int size = 6;
			Board board = new Board(size);
			board.stageOneBoard();

			final boolean EXPECTED = false;
			final String ERROR_MSG = "Music playing ?";
			
//			Act
			board.soundOff();
			final boolean ACTUAL = board.musicStatus;
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		   }
	   catch (IllegalArgumentException e) {
		   System.out.println(e.getMessage());
	   }
	}
	
//	Feature 18 Test
	@Test
	void test57() throws Exception{
		try {
			System.out.println("---------- TEST57 Checking the goal --------------");
//			Arrange
			int size = 6;
			Board board = new Board(size);
			board.stageOneBoard();
			
			final Point EXPECTED = new Point(0,3);
			final String ERROR_MSG = "Goal point must be at 0,3";
			
//			Act
			board.setGoal(0, 3);
			final Point ACTUAL = board.goal[0];
			
//			Assert
			assertEquals(EXPECTED, ACTUAL, ERROR_MSG);
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
}

