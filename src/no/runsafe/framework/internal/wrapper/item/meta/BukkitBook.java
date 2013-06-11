package no.runsafe.framework.internal.wrapper.item.meta;

import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.List;

public abstract class BukkitBook extends RunsafeMeta
{
	public BukkitBook(ItemStack toWrap)
	{
		super(toWrap);
	}

	public BookMeta getRawMeta()
	{
		return (BookMeta) itemStack.getItemMeta();
	}

	public boolean hasTitle()
	{
		return getRawMeta().hasTitle();
	}

	public String getTitle()
	{
		return getRawMeta().getTitle();
	}

	public void setTitle(String title)
	{
		BookMeta book = getRawMeta();
		book.setTitle(title);
		itemStack.setItemMeta(book);
	}

	public boolean hasAuthor()
	{
		return getRawMeta().hasAuthor();
	}

	public String getAuthor()
	{
		return getRawMeta().getAuthor();
	}

	public void setAuthor(String author)
	{
		BookMeta book = getRawMeta();
		book.setAuthor(author);
		itemStack.setItemMeta(book);
	}

	public boolean hasPages()
	{
		return getRawMeta().hasPages();
	}

	public String getPage(int page)
	{
		return getRawMeta().getPage(page);
	}

	public void setPage(int page, String data)
	{
		BookMeta book = getRawMeta();
		book.setPage(page, data);
		itemStack.setItemMeta(book);
	}

	public List<String> getPages()
	{
		return getRawMeta().getPages();
	}

	public void setPages(List<String> pages)
	{
		BookMeta book = getRawMeta();
		book.setPages(pages);
		itemStack.setItemMeta(book);
	}

	public void setPages(String... pages)
	{
		BookMeta book = getRawMeta();
		book.setPages(pages);
		itemStack.setItemMeta(book);
	}

	public void addPages(String... pages)
	{
		BookMeta book = getRawMeta();
		book.addPage(pages);
		itemStack.setItemMeta(book);
	}

	public int getPageCount()
	{
		return getRawMeta().getPageCount();
	}
}
