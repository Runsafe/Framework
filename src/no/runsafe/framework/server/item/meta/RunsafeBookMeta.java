package no.runsafe.framework.server.item.meta;

import org.bukkit.inventory.meta.BookMeta;

import java.util.List;
import java.util.Map;

public class RunsafeBookMeta extends RunsafeItemMeta
{
	public RunsafeBookMeta(BookMeta meta)
	{
		super(meta);
		book = meta;
	}

	public boolean hasTitle()
	{
		return book.hasTitle();
	}

	public String getTitle()
	{
		return book.getTitle();
	}

	public boolean setTitle(String title)
	{
		return book.setTitle(title);
	}

	public boolean hasAuthor()
	{
		return book.hasAuthor();
	}

	public String getAuthor()
	{
		return book.getAuthor();
	}

	public void setAuthor(String author)
	{
		book.setAuthor(author);
	}

	public boolean hasPages()
	{
		return book.hasPages();
	}

	public String getPage(int page)
	{
		return book.getPage(page);
	}

	public void setPage(int page, String data)
	{
		book.setPage(page, data);
	}

	public List<String> getPages()
	{
		return book.getPages();
	}

	public void setPages(List<String> pages)
	{
		book.setPages(pages);
	}

	public void setPages(String... pages)
	{
		book.setPages(pages);
	}

	public void addPage(String... pages)
	{
		book.addPage(pages);
	}

	public int getPageCount()
	{
		return book.getPageCount();
	}

	private final BookMeta book;
}
