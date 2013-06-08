package no.runsafe.framework.wrapper.item.meta;

import no.runsafe.framework.server.item.RunsafeItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.List;

public abstract class BukkitBook extends RunsafeItemStack
{
	public BukkitBook(ItemStack toWrap)
	{
		super(toWrap);
		book = (BookMeta) toWrap.getItemMeta();
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

	@Override
	public ItemStack getRaw()
	{
		itemStack.setItemMeta(book);
		return itemStack;
	}

	protected final BookMeta book;
}
