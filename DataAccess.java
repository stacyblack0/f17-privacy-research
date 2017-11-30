import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tree.Rule;

import java.sql.*;
import java.util.Calendar;


public class DataAccess {

	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	private void createConnection() throws Exception {
		// This will load the MariaDB "driver"
		Class.forName("org.mariadb.jdbc.Driver");

		// Setup the connection with the DB
		connect = DriverManager.getConnection("jdbc:mariadb://localhost/db?"
				+ "user=root&password=password" +
				"");
	}

	public void select() throws Exception {
		createConnection();
		preparedStatement = connect.prepareStatement("select  * from rulle;");
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			String AuthorName = resultSet.getString("id");
			String Title = resultSet.getString("name");
			System.out.println(AuthorName + " " + Title);
		}
		connect.close();
	}

	public void insertRule(Rule rule) {
		try {
			int id = selectRecipientIDbyName(rule.getRecipientSet());
			createConnection();
			preparedStatement = connect.prepareStatement("INSERT INTO Rules(RecipientSetID,Info,Regex) VALUES (?,?,?);");
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, rule.getInfo());
			preparedStatement.setString(3, rule.getRegex());
			preparedStatement.executeUpdate();
			connect.commit();
			connect.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public void insertHistory(HistoryNode node) {
		try {
			createConnection();
			preparedStatement = connect.prepareStatement("INSERT INTO History(InfoShareEvent,TimeInMillis) VALUES (?,?);");
			preparedStatement.setString(1, node.toString());
			preparedStatement.setLong(2, node.getTimeInMillis());
			preparedStatement.executeUpdate();
			connect.commit();
			connect.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public void insertMetadata(MetadataItem metadataItem) {
		try {
			createConnection();
			preparedStatement = connect.prepareStatement("INSERT INTO Metadata(MetadataName,Field,Start,End) VALUES (?,?,?,?);");
			preparedStatement.setString(1, metadataItem.getName());
			preparedStatement.setInt(2, metadataItem.getField());
			preparedStatement.setInt(3, metadataItem.getStart());
			preparedStatement.setInt(4, metadataItem.getEnd());
			preparedStatement.executeUpdate();
			connect.commit();
			connect.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public Rule selectRulebyRecInfo(String recipientSet, String information) {
		try {
			createConnection();
			preparedStatement = connect.prepareStatement("SELECT * FROM Rules r JOIN RecipientSet rs on r.RecipientSetID=" +
					"rs.ID WHERE rs.RecipientSetName=? AND r.Info=?;");
			preparedStatement.setString(1, recipientSet);
			preparedStatement.setString(2, information);
			resultSet = preparedStatement.executeQuery();
			Rule rule = null;
			while (resultSet.next()) { // should loop 1 or fewer times
				String regex = resultSet.getString("Regex");
				rule = new Rule(information, recipientSet, regex);
			}
			connect.close();
			return rule;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

	public ObservableList<Rule> selectRulesbyIndiInfo(String individual, String information) {
		try {
			createConnection();
			preparedStatement = connect.prepareStatement("SELECT * FROM Rules r JOIN RecipientSet rs on r.RecipientSetID=" +
					"rs.ID JOIN Individuals i on rs.ID=i.RecipientSetID WHERE i.IndividualName=? AND r.Info=?;");
			preparedStatement.setString(1, individual);
			preparedStatement.setString(2, information);
			resultSet = preparedStatement.executeQuery();
			ObservableList<Rule> data = FXCollections.observableArrayList();
			while (resultSet.next()) {
				String setName = resultSet.getString("RecipientSetName");
				String regex = resultSet.getString("Regex");
				data.add(new Rule(information, setName, regex));
			}
			connect.close();
			return data;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

	/**
	 * Selects all history entries that occurred at or later than a given
	 * time.
	 *
	 * @param cal a calendar set to the given time
	 * @return all history entries at or later than the given time
	 */
	public ObservableList<HistoryNode> selectHistoryWithin(Calendar cal) {
		try {
			createConnection();
			preparedStatement = connect.prepareStatement("SELECT * FROM History WHERE TimeInMillis>=?;");
			preparedStatement.setLong(1, cal.getTimeInMillis());
			resultSet = preparedStatement.executeQuery();
			ObservableList<HistoryNode> data = FXCollections.observableArrayList();
			while (resultSet.next()) {
				String infoShareEvent = resultSet.getString("InfoShareEvent");
				long timeInMillis = resultSet.getLong("TimeInMillis");
				data.add(new HistoryNode(infoShareEvent, timeInMillis));
			}
			connect.close();
			return data;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

	public ObservableList<MetadataItem> selectMetadata() {
		try {
			createConnection();
			preparedStatement = connect.prepareStatement("SELECT * FROM Metadata;");
			resultSet = preparedStatement.executeQuery();
			ObservableList<MetadataItem> data = FXCollections.observableArrayList();
			while (resultSet.next()) {
				String name = resultSet.getString("Name");
				int field = resultSet.getInt("Field");
				int start = resultSet.getInt("Start");
				int end = resultSet.getInt("End");
				data.add(new MetadataItem(name, field, start, end));
			}
			connect.close();
			return data;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

	public int selectRecipientIDbyName(String name) {
		try {
			createConnection();
			preparedStatement = connect.prepareStatement("SELECT RecipientSetID FROM RecipientSets rs WHERE rs.RecipientSetName=?;");
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			int result = -1;
			while (resultSet.next()) { // should loop 1 or fewer times
				result = resultSet.getInt("RecipientSetID");
			}
			connect.close();
			return result;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return -1;
	}
//
//	public void insertBook(Books books) throws Exception {
//		createConnection();
//		preparedStatement = connect.prepareStatement("insert into Books(AuthorName,Title,PublisherID,InsertUID,UpdateUID) values (?,?,?,?,?);");
//		preparedStatement.setString(1, books.getAuthorName());
//		preparedStatement.setString(2, books.getTitle());
//		preparedStatement.setInt(3, books.getPublisherID());
//		preparedStatement.setString(4, User.getUsername());
//		preparedStatement.setString(5,User.getUsername());
//		preparedStatement.executeUpdate();
//		connect.commit();
//		connect.close();
//
//	}
//
//	public boolean insertBookCopies(BookCopies bookCopies) throws Exception {
//		createConnection();
//		preparedStatement = connect.prepareStatement("insert into Book_Copies(NoOfCopies,BookId,BranchId,InsertUID,UpdateUID) values (?,?,?,?,?) ;");
//		preparedStatement.setInt(1, bookCopies.getNoOfCopies());
//		preparedStatement.setInt(2, bookCopies.getBookId());
//		preparedStatement.setInt(3, bookCopies.getBranchId());
//		preparedStatement.setString(4, User.getUsername());
//		preparedStatement.setString(5,User.getUsername());
//		int a=preparedStatement.executeUpdate();
//		connect.commit();
//		connect.close();
//		if(a>0)
//			return true;
//		return false;
//	}
//
//	public boolean insertBookLoan(BookLoans bookLoans) throws Exception {
//		createConnection();
//		preparedStatement = connect.prepareStatement("insert into Book_Loans(BookId,BranchId,CardNo,InsertUID,UpdateUID) values (?,?,?,?,?) ;");
//		preparedStatement.setInt(1, bookLoans.getBookId());
//		preparedStatement.setInt(2, bookLoans.getBranchId());
//		preparedStatement.setInt(3, bookLoans.getCardNo());
//		preparedStatement.setString(4, User.getUsername());
//		preparedStatement.setString(5,User.getUsername());
//		int a=preparedStatement.executeUpdate();
//		connect.commit();
//		connect.close();
//		if(a>0)
//			return true;
//		return false;
//	}
//
//	public int selectBookID(Books book) throws Exception {
//		createConnection();
//		preparedStatement = connect.prepareStatement("select BookId from Books where AuthorName=? and Title=? and PublisherID=?;");
//		preparedStatement.setString(1,book.getAuthorName());
//		preparedStatement.setString(2,book.getTitle());
//		preparedStatement.setInt(3,book.getPublisherID());
//		resultSet=preparedStatement.executeQuery();
//		int result=-1;
//		while (resultSet.next()) {
//			result=resultSet.getInt("BookId");
//		}
//		connect.close();
//		return result;
//	}
//
//	public ObservableList<Books> selectBooksFromBranch(int bno) throws Exception {
//		createConnection();
//		preparedStatement = connect.prepareStatement("select  AuthorName,Title from Books a inner join Book_Copies b on a.BookId=b.BookId where BranchId=? and b.NoOfCopies>0;");
//		preparedStatement.setInt(1,bno);
//		resultSet=preparedStatement.executeQuery();
//		ObservableList<Books> data = FXCollections.observableArrayList();
//		while (resultSet.next()) {
//			String AuthorName= resultSet.getString("AuthorName");
//			String Title= resultSet.getString("Title");
//			data.add(new Books(AuthorName,Title,0));
//		}
//		connect.close();
//		return data;
//	}
//	public HashMap<Integer,Books> selectBooksFromBranchWithID(int bno) throws Exception {
//		createConnection();
//		preparedStatement = connect.prepareStatement("select  a.BookId,AuthorName,Title,NoOfCopies from Books a inner join Book_Copies b on a.BookId=b.BookId left outer join Book_Loans c on b.BookId=c.BookId and b.BranchId=c.BranchId  where b.BranchId=? and b.NoOfCopies>0 group by a.Bookid having NoOfCopies-count(a.BookId)>0;");
//		preparedStatement.setInt(1,bno);
//		resultSet=preparedStatement.executeQuery();
//		HashMap<Integer,Books> data = new HashMap<>();
//		while (resultSet.next()) {
//			int id=resultSet.getInt("BookId");
//			String AuthorName= resultSet.getString("AuthorName");
//			String Title= resultSet.getString("Title");
//			data.put(id,new Books(AuthorName,Title,0));
//		}
//		connect.close();
//		return data;
//	}
//	public boolean selectUser(User user) throws Exception {
//		createConnection();
//		statement = connect.createStatement();
//		// resultSet contains the result of the SQL query
//		preparedStatement=connect.prepareStatement("SELECT username,password FROM Users where username=? and password=?;");
//		preparedStatement.setString(1,user.getChUser());
//		preparedStatement.setString(2,user.getChPass());
//		resultSet = preparedStatement.executeQuery();
//		String result="";
//		if (resultSet.next()) {
//			String usern= resultSet.getString("username");
//			String pass= resultSet.getString("password");
//			if (usern.equals(user.getChUser())) {
//				User.setUsername(usern);
//				return true;
//			}
//		}
//		connect.close();
//		return false;
//	}
//	public HashMap selectBranches() throws Exception {
//		createConnection();
//		statement = connect.createStatement();
//		// resultSet contains the result of the SQL query
//		resultSet = statement.executeQuery("SELECT BranchId,BranchName FROM Library_Branches ORDER By BranchId asc;;");
//		HashMap result=new HashMap();
//		while (resultSet.next()) {
//			int id=resultSet.getInt("BranchId");
//			String name= resultSet.getString("BranchName");
//			result.put(id,name);
//		}
//		connect.close();
//		return result;
//	}
//
//	public HashMap selectBorrowers() throws Exception {
//		createConnection();
//		statement = connect.createStatement();
//		// resultSet contains the result of the SQL query
//		resultSet = statement.executeQuery("SELECT CardNo,Name FROM Borrowers ORDER By CardNo asc;");
//		HashMap result=new HashMap();
//		while (resultSet.next()) {
//			int id=resultSet.getInt("CardNo");
//			String name= resultSet.getString("Name");
//			result.put(id,name);
//		}
//		connect.close();
//		return result;
//	}
//
//	public ObservableList<Books> selectBooksBorrowedBy(int cno) throws Exception {
//		createConnection();
//		preparedStatement = connect.prepareStatement("select  AuthorName,Title from Books a inner join Book_Loans b on a.BookId=b.BookId where CardNo=? ;");
//		preparedStatement.setInt(1,cno);
//		resultSet=preparedStatement.executeQuery();
//		ObservableList<Books> data = FXCollections.observableArrayList();
//		while (resultSet.next()) {
//			String AuthorName= resultSet.getString("AuthorName");
//			String Title= resultSet.getString("Title");
//			data.add(new Books(AuthorName,Title,0));
//		}
//		connect.close();
//		return data;
//	}
//
//	public HashMap<Integer,Books> selectCheckedOutBooks() throws Exception {
//		createConnection();
//		preparedStatement = connect.prepareStatement("select  a.BookId,AuthorName,Title from Books a inner join Book_Loans b on a.BookId=b.BookId;");
//		resultSet=preparedStatement.executeQuery();
//		HashMap<Integer,Books> data = new HashMap<>();
//		while (resultSet.next()) {
//			int id=resultSet.getInt("BookId");
//			String AuthorName= resultSet.getString("AuthorName");
//			String Title= resultSet.getString("Title");
//			data.put(id,new Books(AuthorName,Title,0));
//		}
//		connect.close();
//		return data;
//	}
//
//	public HashMap selectCheckedOutBooksBy(int bno,int cno) throws Exception {
//		createConnection();
//		preparedStatement = connect.prepareStatement("select b.BookId,Title,AuthorName from Book_Loans a inner join Books b on a.BookId=b.BookId where BranchId=? and CardNo=?;");
//		preparedStatement.setInt(1,bno);
//		preparedStatement.setInt(2,cno);
//		resultSet=preparedStatement.executeQuery();
//		HashMap<Integer,Books> data = new HashMap<>();
//		while (resultSet.next()) {
//			int id=resultSet.getInt("BookId");
//			String AuthorName= resultSet.getString("AuthorName");
//			String Title= resultSet.getString("Title");
//			data.put(id,new Books(AuthorName,Title,0));
//		}
//		connect.close();
//		return data;
//	}
//	public HashMap selectBorrowersWithLoans(int bno) throws Exception {
//		createConnection();
//		preparedStatement = connect.prepareStatement("select a.CardNo,a.Name from Borrowers a inner join Book_Loans b on a.CardNo=b.CardNo where b.BranchId=?;");
//		preparedStatement.setInt(1,bno);
//		resultSet=preparedStatement.executeQuery();
//		HashMap result=new HashMap();
//		while (resultSet.next()) {
//			int id=resultSet.getInt("CardNo");
//			String name= resultSet.getString("Name");
//			result.put(id,name);
//		}
//		connect.close();
//		return result;
//	}
//
//	public boolean removeBookLoan(BookLoans bookLoans) throws Exception {
//		createConnection();
//		preparedStatement = connect.prepareStatement("delete from Book_Loans where BookId=? and CardNo=? and BranchId=?;");
//		preparedStatement.setInt(1, bookLoans.getBookId());
//		preparedStatement.setInt(2, bookLoans.getCardNo());
//		preparedStatement.setInt(3, bookLoans.getBranchId());
//		int a=preparedStatement.executeUpdate();
//		connect.commit();
//		connect.close();
//		if(a>0)
//			return true;
//		return false;
//	}
//	public ObservableList<CopiesInBranch> selectCheckedOutBooksFromBranch(int bno) throws Exception {
//		createConnection();
//		preparedStatement = connect.prepareStatement("select count(a.BookId) as 'count' ,BranchName from Book_Loans a inner join Library_Branches b on a.BranchId=b.BranchId where a.BookId=? group by BranchName ;");
//		preparedStatement.setInt(1,bno);
//		resultSet=preparedStatement.executeQuery();
//		ObservableList<CopiesInBranch> data = FXCollections.observableArrayList();
//		while (resultSet.next()) {
//			int copy= resultSet.getInt("count");
//			String name= resultSet.getString("BranchName");
//			data.add(new CopiesInBranch(copy,name));
//		}
//		connect.close();
//		return data;
//	}
}
