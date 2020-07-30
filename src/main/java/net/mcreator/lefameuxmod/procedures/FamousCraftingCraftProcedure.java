package net.mcreator.lefameuxmod.procedures;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.lefameuxmod.item.MeteoriteSwordItem;
import net.mcreator.lefameuxmod.item.MeteoritePickaxeItem;
import net.mcreator.lefameuxmod.item.MeteoriteIngotItem;
import net.mcreator.lefameuxmod.item.MeteoriteAxeItem;
import net.mcreator.lefameuxmod.item.IronHandleItem;
import net.mcreator.lefameuxmod.LefameuxmodModElements;

import java.util.function.Supplier;
import java.util.Map;

@LefameuxmodModElements.ModElement.Tag
public class FamousCraftingCraftProcedure extends LefameuxmodModElements.ModElement {
	public FamousCraftingCraftProcedure(LefameuxmodModElements instance) {
		super(instance, 27);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure FamousCraftingCraft!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((new Object() {
			public ItemStack getItemStack(int sltid) {
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					Container _current = ((ServerPlayerEntity) _ent).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							return ((Slot) ((Map) invobj).get(sltid)).getStack();
						}
					}
				}
				return ItemStack.EMPTY;
			}
		}.getItemStack((int) (3))).getItem() == new ItemStack(Items.DIAMOND_AXE, (int) (1)).getItem())) {
			if ((((new Object() {
				public ItemStack getItemStack(int sltid) {
					Entity _ent = entity;
					if (_ent instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) _ent).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								return ((Slot) ((Map) invobj).get(sltid)).getStack();
							}
						}
					}
					return ItemStack.EMPTY;
				}
			}.getItemStack((int) (0))).getItem() == new ItemStack(MeteoriteIngotItem.block, (int) (1)).getItem()) && ((new Object() {
				public int getAmount(int sltid) {
					if (entity instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
								if (stack != null)
									return stack.getCount();
							}
						}
					}
					return 0;
				}
			}.getAmount((int) (0))) == 15))) {
				if ((((new Object() {
					public ItemStack getItemStack(int sltid) {
						Entity _ent = entity;
						if (_ent instanceof ServerPlayerEntity) {
							Container _current = ((ServerPlayerEntity) _ent).openContainer;
							if (_current instanceof Supplier) {
								Object invobj = ((Supplier) _current).get();
								if (invobj instanceof Map) {
									return ((Slot) ((Map) invobj).get(sltid)).getStack();
								}
							}
						}
						return ItemStack.EMPTY;
					}
				}.getItemStack((int) (1))).getItem() == new ItemStack(Blocks.GOLD_BLOCK, (int) (1)).getItem()) && ((new Object() {
					public ItemStack getItemStack(int sltid) {
						Entity _ent = entity;
						if (_ent instanceof ServerPlayerEntity) {
							Container _current = ((ServerPlayerEntity) _ent).openContainer;
							if (_current instanceof Supplier) {
								Object invobj = ((Supplier) _current).get();
								if (invobj instanceof Map) {
									return ((Slot) ((Map) invobj).get(sltid)).getStack();
								}
							}
						}
						return ItemStack.EMPTY;
					}
				}.getItemStack((int) (2))).getItem() == new ItemStack(IronHandleItem.block, (int) (1)).getItem()))) {
					if (entity instanceof PlayerEntity) {
						Container _current = ((PlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								ItemStack _setstack = new ItemStack(MeteoriteAxeItem.block, (int) (1));
								_setstack.setCount((int) 1);
								((Slot) ((Map) invobj).get((int) (10))).putStack(_setstack);
								_current.detectAndSendChanges();
							}
						}
					}
					if (entity instanceof PlayerEntity) {
						Container _current = ((PlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								ItemStack _setstack = new ItemStack(MeteoriteIngotItem.block, (int) (1));
								_setstack.setCount((int) ((new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) entity).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
													if (stack != null)
														return stack.getCount();
												}
											}
										}
										return 0;
									}
								}.getAmount((int) (0))) - 15));
								((Slot) ((Map) invobj).get((int) (0))).putStack(_setstack);
								_current.detectAndSendChanges();
							}
						}
					}
					if (entity instanceof PlayerEntity) {
						Container _current = ((PlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								ItemStack _setstack = new ItemStack(Blocks.GOLD_BLOCK, (int) (1));
								_setstack.setCount((int) ((new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) entity).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
													if (stack != null)
														return stack.getCount();
												}
											}
										}
										return 0;
									}
								}.getAmount((int) (1))) - 1));
								((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
								_current.detectAndSendChanges();
							}
						}
					}
					if (entity instanceof PlayerEntity) {
						Container _current = ((PlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								ItemStack _setstack = new ItemStack(IronHandleItem.block, (int) (1));
								_setstack.setCount((int) ((new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) entity).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
													if (stack != null)
														return stack.getCount();
												}
											}
										}
										return 0;
									}
								}.getAmount((int) (2))) - 1));
								((Slot) ((Map) invobj).get((int) (2))).putStack(_setstack);
								_current.detectAndSendChanges();
							}
						}
					}
				}
			}
		} else if (((new Object() {
			public ItemStack getItemStack(int sltid) {
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					Container _current = ((ServerPlayerEntity) _ent).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							return ((Slot) ((Map) invobj).get(sltid)).getStack();
						}
					}
				}
				return ItemStack.EMPTY;
			}
		}.getItemStack((int) (3))).getItem() == new ItemStack(Items.DIAMOND_PICKAXE, (int) (1)).getItem())) {
			if ((((new Object() {
				public ItemStack getItemStack(int sltid) {
					Entity _ent = entity;
					if (_ent instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) _ent).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								return ((Slot) ((Map) invobj).get(sltid)).getStack();
							}
						}
					}
					return ItemStack.EMPTY;
				}
			}.getItemStack((int) (0))).getItem() == new ItemStack(MeteoriteIngotItem.block, (int) (1)).getItem()) && ((new Object() {
				public int getAmount(int sltid) {
					if (entity instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
								if (stack != null)
									return stack.getCount();
							}
						}
					}
					return 0;
				}
			}.getAmount((int) (0))) == 30))) {
				if ((((new Object() {
					public ItemStack getItemStack(int sltid) {
						Entity _ent = entity;
						if (_ent instanceof ServerPlayerEntity) {
							Container _current = ((ServerPlayerEntity) _ent).openContainer;
							if (_current instanceof Supplier) {
								Object invobj = ((Supplier) _current).get();
								if (invobj instanceof Map) {
									return ((Slot) ((Map) invobj).get(sltid)).getStack();
								}
							}
						}
						return ItemStack.EMPTY;
					}
				}.getItemStack((int) (1))).getItem() == new ItemStack(Blocks.GOLD_BLOCK, (int) (1)).getItem()) && ((new Object() {
					public ItemStack getItemStack(int sltid) {
						Entity _ent = entity;
						if (_ent instanceof ServerPlayerEntity) {
							Container _current = ((ServerPlayerEntity) _ent).openContainer;
							if (_current instanceof Supplier) {
								Object invobj = ((Supplier) _current).get();
								if (invobj instanceof Map) {
									return ((Slot) ((Map) invobj).get(sltid)).getStack();
								}
							}
						}
						return ItemStack.EMPTY;
					}
				}.getItemStack((int) (2))).getItem() == new ItemStack(IronHandleItem.block, (int) (1)).getItem()))) {
					if (entity instanceof PlayerEntity) {
						Container _current = ((PlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								ItemStack _setstack = new ItemStack(MeteoritePickaxeItem.block, (int) (1));
								_setstack.setCount((int) 1);
								((Slot) ((Map) invobj).get((int) (10))).putStack(_setstack);
								_current.detectAndSendChanges();
							}
						}
					}
					if (entity instanceof PlayerEntity) {
						Container _current = ((PlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								ItemStack _setstack = new ItemStack(MeteoriteIngotItem.block, (int) (1));
								_setstack.setCount((int) ((new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) entity).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
													if (stack != null)
														return stack.getCount();
												}
											}
										}
										return 0;
									}
								}.getAmount((int) (0))) - 30));
								((Slot) ((Map) invobj).get((int) (0))).putStack(_setstack);
								_current.detectAndSendChanges();
							}
						}
					}
					if (entity instanceof PlayerEntity) {
						Container _current = ((PlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								ItemStack _setstack = new ItemStack(Blocks.GOLD_BLOCK, (int) (1));
								_setstack.setCount((int) ((new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) entity).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
													if (stack != null)
														return stack.getCount();
												}
											}
										}
										return 0;
									}
								}.getAmount((int) (1))) - 1));
								((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
								_current.detectAndSendChanges();
							}
						}
					}
					if (entity instanceof PlayerEntity) {
						Container _current = ((PlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								ItemStack _setstack = new ItemStack(IronHandleItem.block, (int) (1));
								_setstack.setCount((int) ((new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) entity).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
													if (stack != null)
														return stack.getCount();
												}
											}
										}
										return 0;
									}
								}.getAmount((int) (2))) - 1));
								((Slot) ((Map) invobj).get((int) (2))).putStack(_setstack);
								_current.detectAndSendChanges();
							}
						}
					}
				}
			}
		} else if (((new Object() {
			public ItemStack getItemStack(int sltid) {
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					Container _current = ((ServerPlayerEntity) _ent).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							return ((Slot) ((Map) invobj).get(sltid)).getStack();
						}
					}
				}
				return ItemStack.EMPTY;
			}
		}.getItemStack((int) (3))).getItem() == new ItemStack(Items.DIAMOND_SWORD, (int) (1)).getItem())) {
			if ((((new Object() {
				public ItemStack getItemStack(int sltid) {
					Entity _ent = entity;
					if (_ent instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) _ent).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								return ((Slot) ((Map) invobj).get(sltid)).getStack();
							}
						}
					}
					return ItemStack.EMPTY;
				}
			}.getItemStack((int) (0))).getItem() == new ItemStack(MeteoriteIngotItem.block, (int) (1)).getItem()) && ((new Object() {
				public int getAmount(int sltid) {
					if (entity instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
								if (stack != null)
									return stack.getCount();
							}
						}
					}
					return 0;
				}
			}.getAmount((int) (0))) == 20))) {
				if ((((new Object() {
					public ItemStack getItemStack(int sltid) {
						Entity _ent = entity;
						if (_ent instanceof ServerPlayerEntity) {
							Container _current = ((ServerPlayerEntity) _ent).openContainer;
							if (_current instanceof Supplier) {
								Object invobj = ((Supplier) _current).get();
								if (invobj instanceof Map) {
									return ((Slot) ((Map) invobj).get(sltid)).getStack();
								}
							}
						}
						return ItemStack.EMPTY;
					}
				}.getItemStack((int) (1))).getItem() == new ItemStack(Blocks.GOLD_BLOCK, (int) (1)).getItem()) && ((new Object() {
					public ItemStack getItemStack(int sltid) {
						Entity _ent = entity;
						if (_ent instanceof ServerPlayerEntity) {
							Container _current = ((ServerPlayerEntity) _ent).openContainer;
							if (_current instanceof Supplier) {
								Object invobj = ((Supplier) _current).get();
								if (invobj instanceof Map) {
									return ((Slot) ((Map) invobj).get(sltid)).getStack();
								}
							}
						}
						return ItemStack.EMPTY;
					}
				}.getItemStack((int) (2))).getItem() == new ItemStack(IronHandleItem.block, (int) (1)).getItem()))) {
					if (entity instanceof PlayerEntity) {
						Container _current = ((PlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								ItemStack _setstack = new ItemStack(MeteoriteSwordItem.block, (int) (1));
								_setstack.setCount((int) 1);
								((Slot) ((Map) invobj).get((int) (10))).putStack(_setstack);
								_current.detectAndSendChanges();
							}
						}
					}
					if (entity instanceof PlayerEntity) {
						Container _current = ((PlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								ItemStack _setstack = new ItemStack(MeteoriteIngotItem.block, (int) (1));
								_setstack.setCount((int) ((new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) entity).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
													if (stack != null)
														return stack.getCount();
												}
											}
										}
										return 0;
									}
								}.getAmount((int) (0))) - 20));
								((Slot) ((Map) invobj).get((int) (0))).putStack(_setstack);
								_current.detectAndSendChanges();
							}
						}
					}
					if (entity instanceof PlayerEntity) {
						Container _current = ((PlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								ItemStack _setstack = new ItemStack(Blocks.GOLD_BLOCK, (int) (1));
								_setstack.setCount((int) ((new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) entity).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
													if (stack != null)
														return stack.getCount();
												}
											}
										}
										return 0;
									}
								}.getAmount((int) (1))) - 1));
								((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
								_current.detectAndSendChanges();
							}
						}
					}
					if (entity instanceof PlayerEntity) {
						Container _current = ((PlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								ItemStack _setstack = new ItemStack(IronHandleItem.block, (int) (1));
								_setstack.setCount((int) ((new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) entity).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
													if (stack != null)
														return stack.getCount();
												}
											}
										}
										return 0;
									}
								}.getAmount((int) (2))) - 1));
								((Slot) ((Map) invobj).get((int) (2))).putStack(_setstack);
								_current.detectAndSendChanges();
							}
						}
					}
				}
			}
		} else if (((new Object() {
			public ItemStack getItemStack(int sltid) {
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					Container _current = ((ServerPlayerEntity) _ent).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							return ((Slot) ((Map) invobj).get(sltid)).getStack();
						}
					}
				}
				return ItemStack.EMPTY;
			}
		}.getItemStack((int) (3))).getItem() == new ItemStack(Items.DIAMOND_SHOVEL, (int) (1)).getItem())) {
			if ((((new Object() {
				public ItemStack getItemStack(int sltid) {
					Entity _ent = entity;
					if (_ent instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) _ent).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								return ((Slot) ((Map) invobj).get(sltid)).getStack();
							}
						}
					}
					return ItemStack.EMPTY;
				}
			}.getItemStack((int) (0))).getItem() == new ItemStack(MeteoriteIngotItem.block, (int) (1)).getItem()) && ((new Object() {
				public int getAmount(int sltid) {
					if (entity instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
								if (stack != null)
									return stack.getCount();
							}
						}
					}
					return 0;
				}
			}.getAmount((int) (0))) == 15))) {
				if ((((new Object() {
					public ItemStack getItemStack(int sltid) {
						Entity _ent = entity;
						if (_ent instanceof ServerPlayerEntity) {
							Container _current = ((ServerPlayerEntity) _ent).openContainer;
							if (_current instanceof Supplier) {
								Object invobj = ((Supplier) _current).get();
								if (invobj instanceof Map) {
									return ((Slot) ((Map) invobj).get(sltid)).getStack();
								}
							}
						}
						return ItemStack.EMPTY;
					}
				}.getItemStack((int) (1))).getItem() == new ItemStack(Blocks.GOLD_BLOCK, (int) (1)).getItem()) && ((new Object() {
					public ItemStack getItemStack(int sltid) {
						Entity _ent = entity;
						if (_ent instanceof ServerPlayerEntity) {
							Container _current = ((ServerPlayerEntity) _ent).openContainer;
							if (_current instanceof Supplier) {
								Object invobj = ((Supplier) _current).get();
								if (invobj instanceof Map) {
									return ((Slot) ((Map) invobj).get(sltid)).getStack();
								}
							}
						}
						return ItemStack.EMPTY;
					}
				}.getItemStack((int) (2))).getItem() == new ItemStack(IronHandleItem.block, (int) (1)).getItem()))) {
					if (entity instanceof PlayerEntity) {
						Container _current = ((PlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								ItemStack _setstack = new ItemStack(IronHandleItem.block, (int) (1));
								_setstack.setCount((int) 1);
								((Slot) ((Map) invobj).get((int) (10))).putStack(_setstack);
								_current.detectAndSendChanges();
							}
						}
					}
					if (entity instanceof PlayerEntity) {
						Container _current = ((PlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								ItemStack _setstack = new ItemStack(MeteoriteIngotItem.block, (int) (1));
								_setstack.setCount((int) ((new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) entity).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
													if (stack != null)
														return stack.getCount();
												}
											}
										}
										return 0;
									}
								}.getAmount((int) (0))) - 15));
								((Slot) ((Map) invobj).get((int) (0))).putStack(_setstack);
								_current.detectAndSendChanges();
							}
						}
					}
					if (entity instanceof PlayerEntity) {
						Container _current = ((PlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								ItemStack _setstack = new ItemStack(Blocks.GOLD_BLOCK, (int) (1));
								_setstack.setCount((int) ((new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) entity).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
													if (stack != null)
														return stack.getCount();
												}
											}
										}
										return 0;
									}
								}.getAmount((int) (1))) - 1));
								((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
								_current.detectAndSendChanges();
							}
						}
					}
					if (entity instanceof PlayerEntity) {
						Container _current = ((PlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								ItemStack _setstack = new ItemStack(IronHandleItem.block, (int) (1));
								_setstack.setCount((int) ((new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) entity).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
													if (stack != null)
														return stack.getCount();
												}
											}
										}
										return 0;
									}
								}.getAmount((int) (2))) - 1));
								((Slot) ((Map) invobj).get((int) (2))).putStack(_setstack);
								_current.detectAndSendChanges();
							}
						}
					}
				}
			}
		} else if (((new Object() {
			public ItemStack getItemStack(int sltid) {
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					Container _current = ((ServerPlayerEntity) _ent).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							return ((Slot) ((Map) invobj).get(sltid)).getStack();
						}
					}
				}
				return ItemStack.EMPTY;
			}
		}.getItemStack((int) (3))).getItem() == new ItemStack(Items.DIAMOND_HOE, (int) (1)).getItem())) {
			if ((((new Object() {
				public ItemStack getItemStack(int sltid) {
					Entity _ent = entity;
					if (_ent instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) _ent).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								return ((Slot) ((Map) invobj).get(sltid)).getStack();
							}
						}
					}
					return ItemStack.EMPTY;
				}
			}.getItemStack((int) (0))).getItem() == new ItemStack(MeteoriteIngotItem.block, (int) (1)).getItem()) && ((new Object() {
				public int getAmount(int sltid) {
					if (entity instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
								if (stack != null)
									return stack.getCount();
							}
						}
					}
					return 0;
				}
			}.getAmount((int) (0))) == 10))) {
				if ((((new Object() {
					public ItemStack getItemStack(int sltid) {
						Entity _ent = entity;
						if (_ent instanceof ServerPlayerEntity) {
							Container _current = ((ServerPlayerEntity) _ent).openContainer;
							if (_current instanceof Supplier) {
								Object invobj = ((Supplier) _current).get();
								if (invobj instanceof Map) {
									return ((Slot) ((Map) invobj).get(sltid)).getStack();
								}
							}
						}
						return ItemStack.EMPTY;
					}
				}.getItemStack((int) (1))).getItem() == new ItemStack(Blocks.GOLD_BLOCK, (int) (1)).getItem()) && ((new Object() {
					public ItemStack getItemStack(int sltid) {
						Entity _ent = entity;
						if (_ent instanceof ServerPlayerEntity) {
							Container _current = ((ServerPlayerEntity) _ent).openContainer;
							if (_current instanceof Supplier) {
								Object invobj = ((Supplier) _current).get();
								if (invobj instanceof Map) {
									return ((Slot) ((Map) invobj).get(sltid)).getStack();
								}
							}
						}
						return ItemStack.EMPTY;
					}
				}.getItemStack((int) (2))).getItem() == new ItemStack(IronHandleItem.block, (int) (1)).getItem()))) {
					if (entity instanceof PlayerEntity) {
						Container _current = ((PlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								ItemStack _setstack = new ItemStack(IronHandleItem.block, (int) (1));
								_setstack.setCount((int) 1);
								((Slot) ((Map) invobj).get((int) (10))).putStack(_setstack);
								_current.detectAndSendChanges();
							}
						}
					}
					if (entity instanceof PlayerEntity) {
						Container _current = ((PlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								ItemStack _setstack = new ItemStack(MeteoriteIngotItem.block, (int) (1));
								_setstack.setCount((int) ((new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) entity).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
													if (stack != null)
														return stack.getCount();
												}
											}
										}
										return 0;
									}
								}.getAmount((int) (0))) - 10));
								((Slot) ((Map) invobj).get((int) (0))).putStack(_setstack);
								_current.detectAndSendChanges();
							}
						}
					}
					if (entity instanceof PlayerEntity) {
						Container _current = ((PlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								ItemStack _setstack = new ItemStack(Blocks.GOLD_BLOCK, (int) (1));
								_setstack.setCount((int) ((new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) entity).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
													if (stack != null)
														return stack.getCount();
												}
											}
										}
										return 0;
									}
								}.getAmount((int) (1))) - 1));
								((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
								_current.detectAndSendChanges();
							}
						}
					}
					if (entity instanceof PlayerEntity) {
						Container _current = ((PlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								ItemStack _setstack = new ItemStack(IronHandleItem.block, (int) (1));
								_setstack.setCount((int) ((new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) entity).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
													if (stack != null)
														return stack.getCount();
												}
											}
										}
										return 0;
									}
								}.getAmount((int) (2))) - 1));
								((Slot) ((Map) invobj).get((int) (2))).putStack(_setstack);
								_current.detectAndSendChanges();
							}
						}
					}
				}
			}
		} else if (((new Object() {
			public ItemStack getItemStack(int sltid) {
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					Container _current = ((ServerPlayerEntity) _ent).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							return ((Slot) ((Map) invobj).get(sltid)).getStack();
						}
					}
				}
				return ItemStack.EMPTY;
			}
		}.getItemStack((int) (3))).getItem() == new ItemStack(IronHandleItem.block, (int) (1)).getItem())) {
			if ((((new Object() {
				public ItemStack getItemStack(int sltid) {
					Entity _ent = entity;
					if (_ent instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) _ent).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								return ((Slot) ((Map) invobj).get(sltid)).getStack();
							}
						}
					}
					return ItemStack.EMPTY;
				}
			}.getItemStack((int) (0))).getItem() == new ItemStack(MeteoriteIngotItem.block, (int) (1)).getItem()) && ((new Object() {
				public int getAmount(int sltid) {
					if (entity instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
								if (stack != null)
									return stack.getCount();
							}
						}
					}
					return 0;
				}
			}.getAmount((int) (0))) == 5))) {
				if ((((new Object() {
					public ItemStack getItemStack(int sltid) {
						Entity _ent = entity;
						if (_ent instanceof ServerPlayerEntity) {
							Container _current = ((ServerPlayerEntity) _ent).openContainer;
							if (_current instanceof Supplier) {
								Object invobj = ((Supplier) _current).get();
								if (invobj instanceof Map) {
									return ((Slot) ((Map) invobj).get(sltid)).getStack();
								}
							}
						}
						return ItemStack.EMPTY;
					}
				}.getItemStack((int) (1))).getItem() == new ItemStack(Items.DIAMOND, (int) (1)).getItem()) && ((new Object() {
					public ItemStack getItemStack(int sltid) {
						Entity _ent = entity;
						if (_ent instanceof ServerPlayerEntity) {
							Container _current = ((ServerPlayerEntity) _ent).openContainer;
							if (_current instanceof Supplier) {
								Object invobj = ((Supplier) _current).get();
								if (invobj instanceof Map) {
									return ((Slot) ((Map) invobj).get(sltid)).getStack();
								}
							}
						}
						return ItemStack.EMPTY;
					}
				}.getItemStack((int) (2))).getItem() == new ItemStack(Items.REDSTONE, (int) (1)).getItem()))) {
					if (entity instanceof PlayerEntity) {
						Container _current = ((PlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								ItemStack _setstack = new ItemStack(IronHandleItem.block, (int) (1));
								_setstack.setCount((int) 1);
								((Slot) ((Map) invobj).get((int) (10))).putStack(_setstack);
								_current.detectAndSendChanges();
							}
						}
					}
					if (entity instanceof PlayerEntity) {
						Container _current = ((PlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								ItemStack _setstack = new ItemStack(MeteoriteIngotItem.block, (int) (1));
								_setstack.setCount((int) ((new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) entity).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
													if (stack != null)
														return stack.getCount();
												}
											}
										}
										return 0;
									}
								}.getAmount((int) (0))) - 5));
								((Slot) ((Map) invobj).get((int) (0))).putStack(_setstack);
								_current.detectAndSendChanges();
							}
						}
					}
					if (entity instanceof PlayerEntity) {
						Container _current = ((PlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								ItemStack _setstack = new ItemStack(Blocks.GOLD_BLOCK, (int) (1));
								_setstack.setCount((int) ((new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) entity).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
													if (stack != null)
														return stack.getCount();
												}
											}
										}
										return 0;
									}
								}.getAmount((int) (1))) - 1));
								((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
								_current.detectAndSendChanges();
							}
						}
					}
					if (entity instanceof PlayerEntity) {
						Container _current = ((PlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								ItemStack _setstack = new ItemStack(IronHandleItem.block, (int) (1));
								_setstack.setCount((int) ((new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) entity).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
													if (stack != null)
														return stack.getCount();
												}
											}
										}
										return 0;
									}
								}.getAmount((int) (2))) - 1));
								((Slot) ((Map) invobj).get((int) (2))).putStack(_setstack);
								_current.detectAndSendChanges();
							}
						}
					}
				}
			}
		}
	}
}
