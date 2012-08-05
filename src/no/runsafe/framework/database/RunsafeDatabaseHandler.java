package no.runsafe.framework.database;

import no.runsafe.framework.output.ConsoleColors;
import no.runsafe.framework.output.IOutput;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;

public class RunsafeDatabaseHandler implements IDatabase {
	private final String databaseURL;
	private final String databaseUsername;
	private final String databasePassword;

	private final IOutput output;

	public RunsafeDatabaseHandler(IOutput output) {
		YamlConfiguration config = new YamlConfiguration();
		try {
			config.load("runsafe/db.yml");
		} catch(FileNotFoundException e) {
			config.createSection("database");
			config.set("database.url", "jdbc:mysql://localhost:3306/minecraft");
			config.set("database.username", "minecraftuser");
			config.set("database.password", "p4ssw0rd");
			try {
				config.save("runsafe/db.yml");
			} catch(IOException e1) {
				e1.printStackTrace();
			}
			output.write("\n" +
					"\n" +
					ConsoleColors.RED +
					"================================================================\n" +
					"Created new default runsafe/db.yml - you should change this now!\n" +
					"================================================================" +
					ConsoleColors.reset
			);
		} catch(IOException e) {
			e.printStackTrace();
		} catch(InvalidConfigurationException e) {
			e.printStackTrace();
		}
		this.databaseURL = config.getString("database.url");
		this.databaseUsername = config.getString("database.username");
		this.databasePassword = config.getString("database.password");
		this.output = output;
	}

	@Override
	public Connection beginTransaction() {
		try {
			Connection conn = getConnection();
			conn.setAutoCommit(false);
			return conn;
		} catch(SQLException e) {
			this.output.outputToConsole(e.getMessage(), Level.SEVERE);
			return null;
		}
	}

	@Override
	public void commitTransaction(Connection conn) {
		try {
			conn.commit();
			conn.close();
		} catch(SQLException e) {
			this.output.outputToConsole(e.getMessage() + Arrays.toString(e.getStackTrace()), Level.SEVERE);
		}
	}

	@Override
	public void rollbackTransaction(Connection conn) {
		try {
			conn.rollback();
			conn.close();
		} catch(SQLException e) {
			this.output.outputToConsole(e.getMessage() + Arrays.toString(e.getStackTrace()), Level.SEVERE);
		}
	}

	@Override
	public PreparedStatement prepare(String sql) {
		try {
			Connection conn = getConnection();
			if(conn == null)
				return null;
			return conn.prepareStatement(sql);
		} catch(SQLException e) {
			this.output.outputToConsole(e.getMessage() + Arrays.toString(e.getStackTrace()), Level.SEVERE);
			return null;
		}
	}

	protected Connection getConnection() {
		try {
			output.fine(String.format("Opening connection to %s by %s", databaseURL, databaseUsername));
			if(conn == null || conn.isClosed())
			conn = DriverManager.getConnection(this.databaseURL, this.databaseUsername, this.databasePassword);
			if(conn == null)
				output.fine("Connection is null");
			return conn;
		} catch(SQLException e) {
			this.output.write(e.getMessage());
			return null;
		}
	}

	private Connection conn;
}
