package no.runsafe.framework;

import org.hibernate.Session;

public interface IDatabase {

	Session getSession();

}