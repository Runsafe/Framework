package no.runsafe.framework.server.inventory;

import no.runsafe.framework.server.item.RunsafeItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.List;

public class RunsafePlayerInventory extends RunsafeInventory {
	public RunsafePlayerInventory(PlayerInventory toWrap) {
		super(toWrap);
		inventory = toWrap;
	}

	List<RunsafeItemStack> getArmorContents() {
		return RunsafeItemStack.convert(inventory.getArmorContents());
	}

	RunsafeItemStack getHelmet() {
		return new RunsafeItemStack(inventory.getHelmet());
	}

	RunsafeItemStack getChestplate() {
		return new RunsafeItemStack(inventory.getChestplate());
	}

	RunsafeItemStack getLeggings() {
		return new RunsafeItemStack(inventory.getLeggings());
	}

	RunsafeItemStack getBoots() {
		return new RunsafeItemStack(inventory.getBoots());
	}

	void setArmorContents(List<RunsafeItemStack> itemStacks) {
		ItemStack[] stacks = new ItemStack[itemStacks.size()];
		for(int i = 0; i < itemStacks.size(); ++i)
			stacks[i] = itemStacks.get(i).getRaw();
		inventory.setArmorContents(stacks);
	}

	void setHelmet(RunsafeItemStack itemStack) {
		inventory.setHelmet(itemStack.getRaw());
	}

	void setChestplate(RunsafeItemStack itemStack) {
		inventory.setChestplate(itemStack.getRaw());
	}

	void setLeggings(RunsafeItemStack itemStack) {
		inventory.setLeggings(itemStack.getRaw());
	}

	void setBoots(RunsafeItemStack itemStack) {
		inventory.setBoots(itemStack.getRaw());
	}

	RunsafeItemStack getItemInHand() {
		return new RunsafeItemStack(inventory.getItemInHand());
	}

	void setItemInHand(RunsafeItemStack itemStack) {
		inventory.setItemInHand(itemStack.getRaw());
	}

	int getHeldItemSlot() {
		return inventory.getHeldItemSlot();
	}

	private final PlayerInventory inventory;
}
