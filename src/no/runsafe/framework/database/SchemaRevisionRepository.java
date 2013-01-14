package no.runsafe.framework.database;

import no.runsafe.framework.output.ChatColour;
import no.runsafe.framework.output.IOutput;
import org.apache.commons.lang.exception.ExceptionUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

public class SchemaRevisionRepository
{
	public SchemaRevisionRepository(IDatabase db, IOutput output)
	{
		database = db;
		console = output;
		try
		{
			PreparedStatement create = database.prepare(
				"CREATE TABLE IF NOT EXISTS runsafe_schema (" +
					"`table` varchar(255) NOT NULL," +
					"`revision` int(11) NOT NULL," +
					"PRIMARY KEY (`table`)" +
					")"
			);
			create.execute();
			create.close();
		}
		catch (SQLException e)
		{
			output.writeColoured(
				"Database failure: %s%s%s\n%s",
				Level.SEVERE,
				ChatColour.RED,
				ExceptionUtils.getMessage(e),
				ChatColour.RESET,
				ExceptionUtils.getStackTrace(e)
			);
		}
	}

	public int getRevision(String table)
	{
		PreparedStatement select = database.prepare("SELECT `revision` FROM runsafe_schema WHERE `table`=?");
		try
		{
			select.setString(1, table);
			ResultSet result = select.executeQuery();
			int rev = -1;
			if (result == null || result.wasNull())
				return 0;
			if (result.first())
				rev = result.getInt(1);
			result.close();
			select.close();
			return rev;

		}
		catch (SQLException e)
		{
			console.writeColoured(
				"Database failure: %s%s%s\n%s",
				Level.SEVERE,
				ChatColour.RED,
				ExceptionUtils.getMessage(e),
				ChatColour.RESET,
				ExceptionUtils.getStackTrace(e)
			);
		}
		return -1;
	}

	public void setRevision(String table, int revision)
	{
		PreparedStatement update = database.prepare(
			"INSERT INTO runsafe_schema (`table`,`revision`) VALUES (?,?)" +
				"ON DUPLICATE KEY UPDATE `revision`=VALUES(`revision`)"
		);
		try
		{
			update.setString(1, table);
			update.setInt(2, revision);
			update.execute();
			update.close();

		}
		catch (SQLException e)
		{
			console.writeColoured(
				"Database failure: %s%s%s\n%s",
				Level.SEVERE,
				ChatColour.RED,
				ExceptionUtils.getMessage(e),
				ChatColour.RESET,
				ExceptionUtils.getStackTrace(e)
			);
		}
	}

	private final IDatabase database;
	private final IOutput console;
}
